package com.example.springbootdemo.service;

import com.example.springbootdemo.domain.Admin;

import java.util.List;

public interface AdminService {
     List<Admin> getAdminList();

     Admin loginAdmin(Admin admin);

     Admin getAdminById(String id);
}
