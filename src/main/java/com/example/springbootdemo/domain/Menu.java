package com.example.springbootdemo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {
    private Integer id;
    /**菜单名称*/
    private String menuName;
    /**菜单编码*/
    private String menuCode;
    /**菜单级别*/
    private Integer menuLevel;
    /**父类编码*/
    private String parentCode;
    /**链接地址*/
    private String url;
    /**状态(0:正常 1:冻结 2:删除)*/
    private Integer status;
    /**菜单图片*/
    private String  icon;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
    /**顺序*/
    private Integer sort;

    private List<Menu> menuList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
