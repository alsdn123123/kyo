package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.mapper.AdminDao;
import com.example.springbootdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Admin> getAdminList() {
        return adminDao.getAdminList();
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        return adminDao.loginAdmin(admin);
    }
}
