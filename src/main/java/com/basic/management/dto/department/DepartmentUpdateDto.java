package com.basic.management.dto.department;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 修改单位入参
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "DepartmentUpdateDto",description = "修改单位入参")
public class DepartmentUpdateDto extends DepartmentAddDto{

    @ApiModelProperty(value = "主键")
    private String id;
}
