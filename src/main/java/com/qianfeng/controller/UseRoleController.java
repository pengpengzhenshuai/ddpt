package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.UserRoleService;
import com.qianfeng.entity.Role;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UseRoleController {
    @Autowired
    private UserRoleService userRoleService;


@RequestMapping("/userrole/list.do")
public Map<String,Object> findByAll(Integer page, Integer limit){
    Integer pageSize = limit;
    if(pageSize ==null){
        pageSize=10;
    }
    Map<String,Object> map = userRoleService.findRoleAll(page, limit);

    return map;
}

    @RequestMapping("/userrole/delete.do")
    public JsonBean deleteGradeById(Integer id){

        try {
            userRoleService.deleteById(id);
            return JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }

    @RequestMapping("/userrole/update.do")
    public JsonBean updateGrade(Role role){
        userRoleService.update(role);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/userrole/add.do")
    public JsonBean addGrade(Role role){
        role.setId(1);
        userRoleService.add(role);
        return JsonUtils.createJsonBean(1,null);
    }
}
