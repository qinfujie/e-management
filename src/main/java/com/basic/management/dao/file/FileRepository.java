package com.basic.management.dao.file;

import com.basic.management.entity.file.File;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 文件存储持久化
 *
 * @author fujie
 */
public interface FileRepository extends JpaRepository<File,String> {

    /**
     * 根据文件路径删除文件信息
     *
     * @param path 路径
     */
    void deleteByPath (String path);

}
