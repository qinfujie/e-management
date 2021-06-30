package com.basic.management.entity.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 应用与ES
 *
 * @author fujie
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonDoc {

    @Id
    private String id;

    /**
     * 人员编号
     */
    private String no;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 单位名称
     */
    private String departmentName;
}
