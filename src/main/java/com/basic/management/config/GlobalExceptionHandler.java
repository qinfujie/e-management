package com.basic.management.config;

import com.basic.management.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author fujie
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param req 请求头
     * @param e 异常信息
     * @return Result
     */
    @ExceptionHandler(value = BizException.class)
    public Result bizExceptionHandler(HttpServletRequest req, BizException e){
        log.error("异常接口为:{}",req.getRequestURL().toString());
        log.error("发生业务异常！原因是：{},",e.getMsg());
        return Result.error("发生业务异常！原因是：" + e.getMsg());
    }

    /**
     * 处理空指针的异常
     * @param req 请求头
     * @param e e
     * @return Result
     */
    @ExceptionHandler(value =NullPointerException.class)
    public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:{}",e.getMessage());
        log.error("异常接口为：{}",req.getRequestURL().toString());
        return Result.error("空指针异常！原因是：" + e.getMessage());
    }


    /**
     * 处理其他异常
     * @param req 请求头
     * @param e 异常信息
     * @return Result
     */
    @ExceptionHandler(value =Exception.class)
    public Result exceptionHandler(HttpServletRequest req, Exception e){
        log.error("异常接口为:{}",req.getRequestURL().toString());
        log.error("未知异常,错误信息为:{},",e.getMessage());
        return Result.error("未知异常,错误信息为" + e.getMessage());
    }

}
