package com.basic.management.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fujie
 */
@Data
public class Result<T> implements Serializable {

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

    public static Result ofSuccess() {
        Result result = new Result();
        result.success = true;
        return result;
    }

    public static Result<Object> ofSuccess(Object data) {
        Result<Object> result = new Result<>();
        result.success = true;
        result.setData(data);
        return result;
    }

    public static Result ofFail(String msg, Exception e) {
        Result result = new Result();
        result.success = false;
        result.msg = msg;
        result.e = e;
        return result;
    }

    public static Result ofFail(String msg) {
        Result result = new Result();
        result.success = false;
        result.msg = msg;
        return result;
    }

}
