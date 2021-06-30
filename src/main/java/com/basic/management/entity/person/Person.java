package com.basic.management.entity.person;
import com.basic.management.entity.base.BaseInfo;
import lombok.*;

import javax.persistence.*;

/**
 * 人员信息
 *
 * @author fujie
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Person")
public class Person extends BaseInfo {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(columnDefinition = "int(32) comment '主键id'")
    private Integer id;

    /**
     * 用户编号
     */
    @Column(columnDefinition = "varchar(32) comment '用户编号'")
    private String no;


    /**
     * 用户名
     */
    @Column(columnDefinition = "varchar(32) comment '用户名'")
    private String name;

    /**
     * 单位编号
     */
    @Column(columnDefinition = "varchar(32) comment '单位编号'")
    private String departmentNo;

    /**
     * 单位名称
     */
    @Column(columnDefinition = "varchar(32) comment '单位名称'")
    private String departmentName;

    /**
     * 是否删除
     */
    @Column(columnDefinition = "bit(1) comment '是否删除'")
    private Boolean isDelete = false;


    /**
     * 身份证
     */
    @Column(columnDefinition = "varchar(32) comment '身份证'")
    private String idCard;

}
