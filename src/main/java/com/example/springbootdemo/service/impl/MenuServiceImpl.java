package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.domain.Menu;
import com.example.springbootdemo.mapper.MenuDao;
import com.example.springbootdemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getMenuByList() {
        return menuDao.getMenuByList();
    }
}
