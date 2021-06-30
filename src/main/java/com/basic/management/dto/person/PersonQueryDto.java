package com.basic.management.dto.person;

import com.basic.management.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 人员查询入参
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "人员查询入参",description = "PersonQueryDto")
public class PersonQueryDto extends Page {

    @ApiModelProperty(value = "人员姓名",notes = "模糊搜索")
    private String name;

    @ApiModelProperty(value = "单位编号",notes = "精准查询")
    private String departmentNo;
}
