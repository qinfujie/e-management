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
     * 错误描述
     */
    private String msg;

    /**
     * 异常信息
     */
    private Exception e;

    public static <T> Result<T> success() {
        return Result.<T>builder().success(true).build();
    }


    public static <T> Result<T> success(String msg,T obj) {
        return Result.<T>builder().msg(msg).data(obj).build();
    }

    public static <T> Result<T> success (String msg) {
        return Result.<T>builder().msg(msg).success(true).build();
    }

    public static <T> Result<T> success (T obj) {
        return Result.<T>builder().data(obj).success(true).build();
    }

    public static <T> Result<T> error (String msg) {
        return Result.<T>builder().msg(msg).success(false).build();
    }

    public static <T> Result<T> error (String msg, Exception e) {
        return Result.<T>builder().msg(msg).success(false).e(e).build();
    }

}
