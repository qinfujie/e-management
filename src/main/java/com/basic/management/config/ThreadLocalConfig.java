package com.basic.management.config;

import com.basic.management.vo.user.UserInfo;

/**
 * 用于存储当前线程的数据
 *
 * @author fujie
 */
public class ThreadLocalConfig {

    /**
     * 存储空间
     */
    protected static final ThreadLocal<UserInfo> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 存储登陆者信息
     * <p>
     * 会删除上一次存储的信息 如果不为空
     *
     * @param value 登陆者信息
     */
    public static void setValue(UserInfo value) {
        UserInfo loginInfo = THREAD_LOCAL.get();
        if (loginInfo != null) {
            THREAD_LOCAL.remove();
        }
        THREAD_LOCAL.set(value);
    }

    /**
     * 清空数据
     * <p>
     */
    static void clear() {
        THREAD_LOCAL.remove();
    }
}
