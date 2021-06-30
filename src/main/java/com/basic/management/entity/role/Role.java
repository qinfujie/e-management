package com.basic.management.entity.role;

import com.basic.management.entity.base.BaseInfo;
import lombok.*;
import javax.persistence.*;

/**
 * 角色实体
 *
 * @author fujie
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Role")
public class Role extends BaseInfo {

    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    /**
     * 角色名称
     */
    @Column(columnDefinition = "varchar(32) comment '角色名称'")
    private String name;

    /**
     * 角色类型
     */
    @Column(columnDefinition = "varchar(32) comment '角色类型'")
    private String type;

    /**
     * 角色描述
     */
    @Column(columnDefinition = "varchar(50) comment '角色描述'")
    private String description;

    /**
     * 是否内置
     */
    @Column(columnDefinition = "BIT(1) comment '是否内置'")
    private Boolean isBuiltIn;

    /**
     * 是否可删除
     */
    @Column(columnDefinition = "BIT(1) comment '是否删除'")
    private Boolean isStrikeOut;

}
