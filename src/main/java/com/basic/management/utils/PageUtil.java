package com.basic.management.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.function.Supplier;

/**
 * 分页工具类
 *
 * @author fujie
 */
public class PageUtil {

    /**
     * 分页查询
     *
     * @param pageIndex 页码
     * @param pageSize  页距（条/页）
     * @param supplier  查询
     * @param <T>       结果集类型
     * @return 结果
     */
    public static <T> PageModel<T> query(Integer pageIndex, Integer pageSize, Supplier<List<T>> supplier) {
        Page<Object> page = PageHelper.startPage(pageIndex, pageSize);
        List<T> list = supplier.get();
        return PageModel.<T>builder()
                .pageIndex(pageIndex)
                .pageSize(pageSize)
                .total((int) page.getTotal())
                .data(list)
                .build();
    }
    
}
