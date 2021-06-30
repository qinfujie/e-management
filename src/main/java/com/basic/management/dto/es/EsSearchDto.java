package com.basic.management.dto.es;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 全文检索查询条件
 *
 * @author fujie
 */

@Data
@ApiModel(value = "EsSearchDto",description = "全文检索查询条件")
public class EsSearchDto {

    @NotBlank(message = "索引不能为空！")
    @ApiModelProperty(value = "索引")
    private String index;

    @NotBlank(message = "主键不能为空!")
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "返回字段",notes = "多个字段用,号分割,为空则返回所有字段")
    private String fields;
}
