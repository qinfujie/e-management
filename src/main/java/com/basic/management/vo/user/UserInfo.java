package com.basic.management.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author fujie
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "UserInfo",description = "用户信息")
public class UserInfo {

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户编号")
    private String no;

    @ApiModelProperty(value = "单位编号")
    private String departmentNo;

    @ApiModelProperty(value = "单位名称")
    private String departmentName;

}
