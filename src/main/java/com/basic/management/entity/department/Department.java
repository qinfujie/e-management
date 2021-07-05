package com.basic.management.entity.department;

import com.basic.management.entity.base.BaseInfo;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 单位信息
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Department")
public class Department extends BaseInfo {

    @Id
    @Column(columnDefinition = "varchar(32) comment '主键id'")
    private String id;

    @Column(columnDefinition = "varchar(32) comment '单位编号'")
    private String no;

    @Column(columnDefinition = "varchar(32) comment '单位名称'")
    private String name;

    @Column(columnDefinition = "varchar(32) comment '单位全称'")
    private String fullName;

    @Column(columnDefinition = "varchar(32) comment '父级编号'")
    private String parentNo;

    @Column(columnDefinition = "varchar(32) comment '单位类型'")
    private String typeOf;

    @Column(columnDefinition = "varchar(32) comment '单位级别'")
    private String level;

    @Column(columnDefinition = "varchar(32) comment '单位描述'")
    private String descInfo;

    @Column(columnDefinition = "varchar(32) comment '单位排序'")
    private String sort;

    @Column(columnDefinition = "bit(1) comment '是否删除'")
    private Boolean isDelete;

}
