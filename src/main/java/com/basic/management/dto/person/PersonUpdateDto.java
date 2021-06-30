package com.basic.management.dto.person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 修改人员入参
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "PersonUpdateDto",description = "修改人员入参")
public class PersonUpdateDto extends PersonInsertDto {

    @NotBlank(message = "主键不能为空!")
    @ApiModelProperty(value = "主键")
    private String id;

}
