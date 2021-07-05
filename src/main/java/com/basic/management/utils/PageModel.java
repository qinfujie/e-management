package com.basic.management.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页模型
 *
 * @author fujie
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PageModel<T> {

    /**
     * 页码
     */
    private Integer pageIndex;

    /**
     * 页距（条/页）
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 数据
     */
    private List<T> data;
}
