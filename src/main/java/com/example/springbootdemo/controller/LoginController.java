package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.service.AdminService;
import com.example.springbootdemo.utils.Consts;
import com.example.springbootdemo.utils.MD5Util;
import com.example.springbootdemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {
    @Autowired
    private AdminService adminService;

    /**
     /**
     * 用户登陆方法
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "login")
    public R login(HttpServletRequest request, HttpServletResponse response ) {

        String loginCode = request.getParameter("loginCode");
        String password = request.getParameter("password");
        Admin adminDTO = new Admin();
        adminDTO.setLoginCode(loginCode);
        adminDTO.setPassword(MD5Util.MD5(password));
        adminDTO = adminService.loginAdmin(adminDTO);
        if(adminDTO==null){
            return R.error(1,"账号或密码错误，请重新输入！");
        }
        request.getSession().setAttribute(Consts.SESSION_ADMIN,adminDTO);
        return R.ok("登录成功");
    }

    /**
     /**
     * 用户退出方法
     * @param request
     * @return
     */
    @RequestMapping(value = "loginOut")
    public R loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute(Consts.SESSION_ADMIN);
        return R.ok("退出登录成功");
    }
}
