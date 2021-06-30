package com.basic.management.config;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.basic.management.constant.SystemCons;
import com.basic.management.utils.TokenUtils;
import com.basic.management.vo.user.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.basic.management.constant.SystemCons.TOKEN;

/**
 * 过滤器
 *
 * @author fujie
 */
@Slf4j
@Configuration
public class CharacterFilter implements Filter  {

    private final HttpServletContent servletContent;

    /**
     * 放行
     */
    private final static List<String> RELEASE = new ArrayList<>();


    static {
        RELEASE.add("/login");
        RELEASE.add(".js");
        RELEASE.add(".html");
        RELEASE.add(".ico");
        RELEASE.add("swagger");
        RELEASE.add("docs");
        RELEASE.add("/file");
    }

    public CharacterFilter(HttpServletContent servletContent) {
        this.servletContent = servletContent;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取请求头信息并校验token,如果属于放行接口则直接放行
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String uri = request.getRequestURL().toString();
        for (String str:RELEASE) {
            if (uri.contains(str)) {
                log.info("正常放行,请求路径为：{}",uri);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            log.info("token不存在<|>,请求路径为:{}",uri);
            return;
        }
        if (token.equals(TOKEN)) {
            log.info("内部调试放行->,请求路径为：{}",uri);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        boolean isEffect = false;
        try {
            isEffect = TokenUtils.verifyToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!isEffect) {
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            ObjectMapper mapper = new ObjectMapper();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(mapper.writeValueAsString(SystemCons.TOKEN_INVALIDATION));
            return;
        }
        // 获取全局对象,设置全局变量,解析token
        UserInfo info = TokenUtils.parseToken(token);
        servletContent.getServletContext().setAttribute(SystemCons.USER_INFO, JSON.toJSONString(info));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
