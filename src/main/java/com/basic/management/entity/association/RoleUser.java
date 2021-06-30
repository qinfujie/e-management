package com.basic.management.entity.association;

import com.basic.management.entity.base.BaseInfo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色用户关联表
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "RoleUser")
public class RoleUser extends BaseInfo {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    /**
     * 用户编号
     */
    @Column(columnDefinition = "varchar(32) comment '用户编号'")
    private String userId;

    /**
     * 角色编号
     */
    @Column(columnDefinition = "varchar(32) comment '角色编号'")
    private String roleId;
}
