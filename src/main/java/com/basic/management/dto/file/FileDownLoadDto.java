package com.basic.management.dto.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件下载入参
 *
 * @author fujie
 */

@Data
@ApiModel(value = "FileDownLoadDto",description = "文件下载入参")
public class FileDownLoadDto {

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String url;
}
