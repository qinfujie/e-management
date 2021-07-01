package com.basic.management.vo;

import cn.hutool.core.util.ObjectUtil;
import com.basic.management.config.ThreadLocalConfig;
import com.basic.management.vo.user.UserInfo;

/**
 * 存储登录信息
 *
 * @author fujie
 */
public class LoginInfo extends ThreadLocalConfig {

    /**
     * 获取用户信息
     *
     * @return UserInfo
     */
    private static UserInfo getUserInfo() {
        return THREAD_LOCAL.get();
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public static String getUserName () {
        UserInfo userInfo = getUserInfo();
        if (ObjectUtil.isEmpty(userInfo)) {
            return null;
        }
        return userInfo.getName();
    }

    /**
     * 获取人员编号
     *
     * @return 人员编号
     */
    public static String getUserNo () {
        UserInfo userInfo = getUserInfo();
        if (ObjectUtil.isEmpty(userInfo)) {
            return null;
        }
        return userInfo.getNo();
    }

    /**
     * 获取单位编号
     *
     * @return 单位编号
     */
    public static String getDepartmentNo () {
        UserInfo userInfo = getUserInfo();
        if (ObjectUtil.isEmpty(userInfo)) {
            return null;
        }
        return userInfo.getDepartmentNo();
    }

    /**
     * 获取单位名称
     *
     * @return 单位名称
     */
    public static String getDepartmentName () {
        UserInfo userInfo = getUserInfo();
        if (ObjectUtil.isEmpty(userInfo)) {
            return null;
        }
        return userInfo.getDepartmentName();
    }

}
