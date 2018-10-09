package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.AdminDao;
import com.example.springbootdemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public String index(){
       /* ModelAndView model = new ModelAndView();
        model.setViewName("index");*/
       return "index";
    }
}
