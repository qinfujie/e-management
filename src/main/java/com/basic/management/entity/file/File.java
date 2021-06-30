package com.basic.management.entity.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author fujie
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "File")
public class File {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    @Column(columnDefinition = "varchar(64) comment '文件名称'")
    private String name;

    @Column(columnDefinition = "varchar(200) comment '文件全路径'")
    private String fullUrl;

    @Column(columnDefinition = "varchar(64) comment '文件后缀'")
    private String extension;

    @Column(columnDefinition = "varchar(64) comment '文件大小'")
    private String size;

    @Column(columnDefinition = "varchar(64) comment '文件组'")
    private String groupName;

    @Column(columnDefinition = "varchar(128) comment '文件路径'")
    private String path;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;
}
