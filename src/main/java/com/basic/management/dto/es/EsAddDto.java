package com.basic.management.dto.es;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * es添加数据入参
 *
 * @author fujie
 */
@Data
@ApiModel(value = "EsAddDto",description = "es添加数据入参")
public class EsAddDto {

    @NotNull(message = "入参数据不能为空!")
    @ApiModelProperty(value = "入参数据")
    private Object obj;

    @NotBlank(message = "索引不能为空!")
    @ApiModelProperty(value = "索引")
    private String index;

    @NotBlank(message = "主键不能为空!")
    @ApiModelProperty(value = "主键")
    private String id;

}
