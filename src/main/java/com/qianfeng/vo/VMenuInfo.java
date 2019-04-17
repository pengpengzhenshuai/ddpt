package com.qianfeng.vo;

import java.util.List;

public class VMenuInfo {
    private Integer id;
    private String aurl;
    private String aicon;
    private String title;

    private List<VMenuInfo> menuList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getAicon() {
        return aicon;
    }

    public void setAicon(String aicon) {
        this.aicon = aicon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VMenuInfo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<VMenuInfo> menuList) {
        this.menuList = menuList;
    }
}
