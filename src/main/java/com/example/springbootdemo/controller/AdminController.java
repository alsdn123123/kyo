package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.service.AdminService;
import com.example.springbootdemo.utils.Consts;
import com.example.springbootdemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("loginAdmin")
    public R loginAdmin(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute(Consts.SESSION_ADMIN);
        Admin admin1 = adminService.loginAdmin(admin);
        if (admin.equals(admin1)){
            return R.ok().data(admin);
        }else{
            request.getSession().setAttribute(Consts.SESSION_ADMIN,admin1);
            return R.ok().data(admin1);
        }
    }
}
