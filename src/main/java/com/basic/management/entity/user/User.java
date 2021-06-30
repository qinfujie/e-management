package com.basic.management.entity.user;

import com.basic.management.entity.base.BaseInfo;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user")
public class User extends BaseInfo {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    /**
     * 人员编号
     */
    @Column(columnDefinition = "varchar(32) comment '人员编号'")
    private String personNo;

    /**
     * 用户名
     */
    @Column(columnDefinition = "varchar(32) comment '用户名'")
    private String name;

    /**
     * 密码
     */
    @Column(columnDefinition = "varchar(32) comment '密码'")
    private String password;

    /**
     * 身份证
     */
    @Column(columnDefinition = "varchar(32) comment '身份证'")
    private String idCard;
}
