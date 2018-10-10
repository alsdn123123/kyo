package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.service.AdminService;
import com.example.springbootdemo.utils.Consts;
import com.example.springbootdemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("loginAdmin")
    public R loginAdmin(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute(Consts.SESSION_ADMIN);
        return R.ok().data(admin);
    }
    @RequestMapping("modifyPwd")
    public ModelAndView modifyPwd(String id){
        Admin admin = adminService.getAdminById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("admin/modifyPwd");
        return modelAndView;
    }
}
