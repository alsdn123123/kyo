package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {
    /**
     /**
     * 用户登陆方法
     * @return
     */
    @RequestMapping(value = "login")
    public String login() {
        return "/login";
    }
    /**
     /**
     * 用户登陆方法
     * @return
     */
    @RequestMapping(value = "index")
    public String index() {
        return "/index";
    }
}
