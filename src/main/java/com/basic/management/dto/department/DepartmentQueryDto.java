package com.basic.management.dto.department;

import com.basic.management.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

/**
 * 单位查询入参
 *
 * @author fujie
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "DepartmentQueryDto",description = "单位查询入参")
public class DepartmentQueryDto extends Page {

    @ApiModelProperty(value = "单位编号")
    private String no;

    @ApiModelProperty(value = "单位类型")
    private String typeOf;

    @ApiModelProperty(value = "单位级别")
    private String level;

}
