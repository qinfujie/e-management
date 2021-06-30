package com.basic.management.utils;

import lombok.*;


/**
 * @author fujie
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Result<T> {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 服务器当前时间戳
     */
    private Long ts = System.currentTimeMillis();

    /**
     * 成功数据
     */
    private T data;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 异常信息
     */
    private Exception e;

    public static <T> Result success () {
        return Result.builder().success(true).build();
    }

    public static <T> Result success(String msg,T obj) {
        return Result.builder().success(true).msg(msg).data(obj).build();
    }

    public static <T> Result success (String msg) {
        return Result.builder().msg(msg).success(true).build();
    }

    public static <T> Result success (T obj) {
        return Result.builder().success(true).data(obj).build();
    }

    public static <T> Result error (String msg) {
        return Result.builder().success(false).msg(msg).build();
    }

    public static <T> Result error (String msg, Exception e) {
        return Result.builder().success(false).msg(msg).e(e).build();
    }

}
