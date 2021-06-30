package com.basic.management.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 初始化配置
 *
 * @author fujie
 */
@Data
public class Page {

    @ApiModelProperty(value = "起始页")
    private Integer  row = 0;

    @ApiModelProperty(value = "起始大小")
    private Integer pageSize = 15;
}
