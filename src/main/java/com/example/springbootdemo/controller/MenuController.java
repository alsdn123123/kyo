package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Admin;
import com.example.springbootdemo.domain.Menu;
import com.example.springbootdemo.service.MenuService;
import com.example.springbootdemo.utils.Consts;
import com.example.springbootdemo.utils.R;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("menu")
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value="list")
    public R list(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute(Consts.SESSION_ADMIN);
        List<Menu> menuDTOList = new ArrayList<Menu>();
        List<Menu> menuDTORemoveList = new LinkedList<>();
        menuDTOList = menuService.getMenuByList();
        for(Menu menuDTO2 : menuDTOList){
            if(menuDTO2.getMenuLevel()!=null && menuDTO2.getMenuLevel()==2){
                a:for(Menu menuDTO1 : menuDTOList){
                    if(menuDTO1.getMenuLevel()!=null &&
                            StringUtils.isNotBlank(menuDTO1.getMenuCode()) &&
                            StringUtils.isNotBlank(menuDTO2.getParentCode()) &&
                            menuDTO1.getMenuLevel()==1 &&
                            menuDTO1.getMenuCode().equals(menuDTO2.getParentCode())&&
                            admin.getAdminRole() >=menuDTO2.getMenuRole()){
                        if(menuDTO1.getMenuList()==null && admin.getAdminRole() >=  menuDTO1.getMenuRole()){
                            List<Menu> menuDTOList12 = new ArrayList<Menu>();
                            menuDTO1.setMenuList(menuDTOList12);
                        }
                        menuDTO1.getMenuList().add(menuDTO2);
                        //menuDTOList.remove(menuDTO2);
                        break a;
                    }
                }
                menuDTORemoveList.add(menuDTO2);
            }
        }
        menuDTOList.removeAll(menuDTORemoveList);

        return R.ok().data(menuDTOList);
    }
}
