package com.basic.management.vo.file;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件返回信息
 *
 * @author fujie
 */

@Data
@ApiModel(value = "FileInfoVo",description = "文件返回信息")
public class FileInfoVo {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件全路径",notes = "前端可直接访问")
    private String fullUrl;

    @ApiModelProperty(value = "文件后缀")
    private String extension;

    @ApiModelProperty(value = "文件大小")
    private String size;

    @ApiModelProperty(value = "文件组")
    private String groupName;

    @ApiModelProperty(value = "文件路径")
    private String path;
}
