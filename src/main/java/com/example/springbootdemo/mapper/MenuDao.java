package com.example.springbootdemo.mapper;

import com.example.springbootdemo.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MenuDao {
    List<Menu> getMenuByList();
}
