package com.basic.management.dto.person;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 人员信息
 *
 * @author fujie
 */

@Data
@ApiModel(value = "PersonInsertDto",description = "人员信息")
public class PersonInsertDto {

    @NotBlank(message = "用户名不能为空!")
    @ApiModelProperty(value = "用户名")
    private String name;

    @NotBlank(message = "身份证不能为空")
    @ApiModelProperty(value = "身份证")
    private String idCard;

    /**
     * 单位编号
     */
    @NotBlank(message = "单位编号不能为空")
    @ApiModelProperty(value = "单位编号")
    private String departmentNo;

    /**
     * 单位名称
     */
    @NotBlank(message = "单位名称不能为空")
    @ApiModelProperty(value = "单位名称")
    private String departmentName;

}
