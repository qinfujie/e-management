package com.basic.management.config;

import com.basic.management.constant.SystemCons;
import com.basic.management.vo.user.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * @author fujie
 */
@Configuration
public class HttpServletContent extends HttpServlet {

    @Override
    public ServletContext getServletContext() {
        return super.getServletContext();
    }

    /**
     * 获取用户登录信息
     *
     * @return UserInfo
     */
    public UserInfo getUserInfo () {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(getServletContext().getAttribute(SystemCons.USER_INFO),UserInfo.class);
    }
}
