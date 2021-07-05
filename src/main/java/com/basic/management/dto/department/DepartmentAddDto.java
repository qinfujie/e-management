package com.basic.management.dto.department;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 单位新增入参
 *
 * @author fujie
 */

@Data
@ApiModel(value = "DepartmentAddDto",description = "单位新增入参")
public class DepartmentAddDto {

    @ApiModelProperty(value = "单位编号",notes = "单位唯一标识")
    private String no;

    @NotBlank(message = "单位名称不能为空!")
    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "单位全称")
    private String fullName;

    @NotBlank(message = "父级编号不能为空!")
    @ApiModelProperty(value = "父级编号")
    private String parentNo;

    @ApiModelProperty(value = "单位类型")
    private String type;

    @ApiModelProperty(value = "单位级别")
    private String level;

    @ApiModelProperty(value = "单位描述")
    private String desc;

    @ApiModelProperty(value = "单位排序",hidden = true)
    private String sort;

    @ApiModelProperty(value = "是否删除",hidden = true)
    private Boolean isDelete;

}
