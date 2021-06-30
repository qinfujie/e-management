package com.basic.management.utils;
import com.basic.management.config.AppConfig;
import com.basic.management.dao.file.FileRepository;
import com.basic.management.dto.file.FileDownLoadDto;
import com.basic.management.entity.file.File;
import com.basic.management.vo.file.FileInfoVo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author fujie
 */

@Slf4j
@Component
public class FastDfsClientUtil {

    private final static String HTTP = "http://";

    private final FastFileStorageClient storageClient;

    private final AppConfig appConfig;

    private final FileRepository fileRepository;

    public FastDfsClientUtil(FastFileStorageClient storageClient,
                             AppConfig appConfig,
                             FileRepository fileRepository) {
        this.storageClient = storageClient;
        this.appConfig = appConfig;
        this.fileRepository = fileRepository;
    }


    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException 异常
     */
    @Transactional(rollbackOn = Exception.class)
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        String resAccessUrl = getResAccessUrl(storePath);
        File resource = File.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .fullUrl(resAccessUrl)
                .groupName(storePath.getGroup())
                .name(file.getOriginalFilename())
                .size(String.valueOf(file.getSize()))
                .path(storePath.getPath())
                .createTime(new Date())
                .build();
        fileRepository.save(resource);
        return resAccessUrl;
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException 异常信息
     */
    public String uploadFile(java.io.File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
        return getResAccessUrl(storePath);
    }


    /**
     * 下载文件
     *
     * @param downLoadDto 文件URL
     * @param response    相应信息
     * @throws IOException 异常
     */
    public void downloadFile(FileDownLoadDto downLoadDto, HttpServletResponse response) throws IOException {
        StorePath storePath = StorePath.praseFromUrl(downLoadDto.getUrl());
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(
                downLoadDto.getFileName() + storePath.getPath().substring(storePath.getPath().lastIndexOf(".")), "UTF-8"));
        ServletOutputStream outputStream = null;
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        java.io.File file = new java.io.File(downLoadDto.getFileName());
        try {
            byte[] content = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), downloadByteArray);
            if (content == null || content.length == 0) {
                log.error("文件大小为空！");
                boolean flag = file.delete();
                log.info("删除文件结果：{}", flag);
                return;
            }
            outputStream = response.getOutputStream();
            outputStream.write(content);
            log.info("成功下载文件： " + downLoadDto.getFileName());
        } catch (Exception e) {
            log.error("error", e);
        } finally {
            assert outputStream != null;
            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension 文件
     * @return String
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return getResAccessUrl(storePath);
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     */
    @Transactional(rollbackOn = Exception.class)
    public void deleteFile(String fileUrl) {
        try {
            // 检验文件是否存在
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            // 删除文件并删除本地存储
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
            fileRepository.deleteByPath(storePath.getPath());
            log.info("删除文件成功!");
        } catch (FdfsUnsupportStorePathException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 封装图片完成地址
     *
     * @param storePath 图片地址
     * @return String
     */
    private String getResAccessUrl(StorePath storePath) {
        return HTTP + appConfig.getResHost()
                + ":" + appConfig.getFastStoragePort() + "/" + storePath.getFullPath();
    }

    /**
     * 查询所有文件
     *
     * @return 文件列表
     */
    public List<FileInfoVo> findAll() {
        List<File> all = fileRepository.findAll();
        if (all.isEmpty()) {
            return new ArrayList<>();
        }
        return all.stream().map(s -> {
            FileInfoVo infoVo = new FileInfoVo();
            BeanUtils.copyProperties(s, infoVo);
            return infoVo;
        }).collect(Collectors.toList());
    }

}
