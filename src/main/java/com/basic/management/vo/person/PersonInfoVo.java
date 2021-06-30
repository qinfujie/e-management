package com.basic.management.vo.person;

import com.basic.management.entity.base.BaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 人员信息返回类
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "PersonInfoVo",description = "人员信息返回类")
public class PersonInfoVo extends BaseInfo {

    @ApiModelProperty(value = "主键",notes = "唯一标识")
    private Integer id;

    @ApiModelProperty(value = "人员编号")
    private String no;

    @ApiModelProperty(value = "人员名称")
    private String name;

    @ApiModelProperty(value = "单位编号")
    private String departmentNo;

    @ApiModelProperty(value = "单位名称")
    private String departmentName;

    @ApiModelProperty(value = "是否删除",hidden = true)
    private Boolean isDelete;

    @ApiModelProperty(value = "身份证")
    private String idCard;



}
