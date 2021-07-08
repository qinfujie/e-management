package com.basic.management.vo.department;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 单位返回类
 *
 * @author fujie
 */
@Data
public class DepartmentVo {

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "单位编号")
    private String no;

    @ApiModelProperty(value = "单位名称")
    private String name;

    @ApiModelProperty(value = "单位全程")
    private String fullName;

    @ApiModelProperty(value = "父级编号")
    private String parentNo;

    @ApiModelProperty(value = "单位类型")
    private String typeOf;

    @ApiModelProperty(value = "单位级别")
    private String level;

    @ApiModelProperty(value = "单位描述")
    private String descInfo;

    @ApiModelProperty(value = "单位排序")
    private String sort;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

}
