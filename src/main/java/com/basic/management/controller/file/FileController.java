package com.basic.management.controller.file;
import com.basic.management.dto.file.FileDownLoadDto;
import com.basic.management.utils.FastDfsClientUtil;
import com.basic.management.vo.file.FileInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;

/**
 * 文件controller
 *
 * @author fujie
 */

@Slf4j
@RestController
@Api(value = "文件工具类", tags = "文件工具类")
@RequestMapping("/file")
public class FileController {

    private final FastDfsClientUtil dfsClientUtil;

    public FileController(FastDfsClientUtil dfsClientUtil) {
        this.dfsClientUtil = dfsClientUtil;
    }

    /**
     * 上传图片
     *
     * @param file 文件
     */
    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(MultipartFile file) {
        String filePath;
        try {
            filePath = dfsClientUtil.uploadFile(file);
        } catch (Exception e) {
            log.error("上传文件异常信息为:{}", e.getMessage());
            return;
        }
        log.info("文件路径为:{}", filePath);
    }

    /**
     * 下载文件
     *
     * @param path 文件路径
     */
    @ApiOperation(value = "文件删除", notes = "文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete(@RequestParam @NotEmpty(message = "文件路径不能为空！") String path) {
        dfsClientUtil.deleteFile(path);
    }

    /**
     * 文件下载
     *
     * @param downLoadDto 文件下载入参
     * @throws IOException io异常
     */
    @ApiOperation(value = "文件下载", notes = "文件下载")
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void download(@RequestBody FileDownLoadDto downLoadDto, HttpServletResponse response) throws IOException {
        dfsClientUtil.downloadFile(downLoadDto, response);
    }

    /**
     * 查询所有文件列表
     *
     * @return List<FileInfoVo>
     */
    @ApiOperation(value = "查询所有文件", notes = "查询所有文件")
    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    public List<FileInfoVo> findAll() {
        return dfsClientUtil.findAll();
    }
}
