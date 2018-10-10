package com.example.springbootdemo.mapper;

import com.example.springbootdemo.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao {
    List<Admin> getAdminList();

    Admin loginAdmin(Admin admin);

    Admin getAdminById(String id);
}
