package com.basic.management.utils;


/**
 * 计算工具类
 *
 * @author fujie
 */
public class MathUtil {

    /**
     * 获取人员编号
     *
     * @param id 主键
     * @return String
     */
    public static String getPersonNo (Integer id) {
        return String.valueOf(10000000+id);
    }
}
