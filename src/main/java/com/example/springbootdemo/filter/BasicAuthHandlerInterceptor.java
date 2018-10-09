package com.example.springbootdemo.filter;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.utils.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthHandlerInterceptor extends HandlerInterceptorAdapter {
    private Logger log = LoggerFactory.getLogger(BasicAuthHandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute(Consts.SESSION_ADMIN);

        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String contextPath = request.getContextPath();
        log.info("AuthFilter======>>当前访问url为{"+uri+"} 项目目录为{"+contextPath+"} IP {"+ip+"}");
        try {
            if (null == admin) {//判断是否有用户信息
                response.sendRedirect(contextPath+"login");//跳转登录页面
                return false;
            }
           return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
