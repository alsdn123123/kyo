package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.utils.Consts;
import com.example.springbootdemo.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("loginAdmin")
    public R loginAdmin(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute(Consts.SESSION_ADMIN);
        return R.ok().data(admin);
    }
}
