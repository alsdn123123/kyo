package com.example.springbootdemo.filter;

import com.example.springbootdemo.utils.Consts;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(AuthFilter.class);
    private String[] exclude;
    private String[] excludeOne = { "js", "png", "jpg", "jpeg", "css", "jsp","html","eot","svg","ttf","woff"  };
    private static String LOGIN_PATH = "/login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (StringUtils.isNotBlank(filterConfig.getInitParameter("exclude"))) {
            String ex[] = filterConfig.getInitParameter("exclude").trim().split(",");
            exclude = new String[ex.length];
            for (int i = 0; i < ex.length; i++) {
                exclude[i] = ex[i].trim();
            }
        }
        log.info("AuthFilter======>>拦截器初始化完成，不拦截地址封装");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Object SESSION_ADMIN = req.getSession().getAttribute(Consts.SESSION_ADMIN);

        String uri = req.getRequestURI();
        String ip = req.getRemoteAddr();
        String contextPath = req.getContextPath();
        log.info("AuthFilter======>>当前访问url为{"+uri+"} 项目目录为{"+contextPath+"} IP {"+ip+"}");
        try {
            /*if (isNeedCheck(uri) && contextPath.contains("hjy")) {//判断是否拦截地址及本项目*/
                if (null == SESSION_ADMIN) {//判断是否有用户信息
                    res.sendRedirect(contextPath+LOGIN_PATH);//跳转登录页面
                    return;
                }
            //}
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 是否需要处理
     *
     * @param uri
     * @return
     */
    private boolean isNeedCheck(String uri) {
        for (int i = 0; i < excludeOne.length; i++) {
            int one = uri.lastIndexOf(".");
            if (one > -1) {
                String oneStr = uri.substring((one + 1), uri.length());
                if (oneStr.toLowerCase().contains(excludeOne[i])) {
                    return false;
                }
            }
        }
        if (null != exclude) {
            for (int i = 0; i < exclude.length; i++) {
                if (uri.contains(exclude[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void destroy() {

    }


}
