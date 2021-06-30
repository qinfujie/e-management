package com.basic.management.entity.menu;

import com.basic.management.entity.base.BaseInfo;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单地址
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Menu")
public class Menu extends BaseInfo {

    /**
     * 主键
     */
    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    /**
     * 父级编号
     */
    @Column(columnDefinition = "varchar(32) comment '父级编号'")
    private String parentId;

    /**
     * 类型
     */
    @Column(columnDefinition = "varchar(32) comment '类型'")
    private String type;

    /**
     * 名称
     */
    @Column(columnDefinition = "varchar(20) comment '名称'")
    private String name;

    /**
     * 路径
     */
    @Column(columnDefinition = "varchar(20) comment '路径'")
    private String url;

    /**
     * code
     */
    @Column(columnDefinition = "varchar(20) comment 'code'")
    private String code;

    /**
     * 是否显示
     */
    @Column(columnDefinition = "bit(1) comment '是否显示'")
    private Boolean isDisplay;

    /**
     * 是否子节点
     */
    @Column(columnDefinition = "bit(1) comment '是否子节点'")
    private Boolean isChildNode;
}
