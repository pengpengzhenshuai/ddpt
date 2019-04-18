package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VUserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UseRoleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserRole.do")
   public Map<String,Object> findAllUserRole(int page,int limit ,String no, Integer flag){

            Map<String, Object> map = new HashMap<>();
            List<VUserRoleInfo> list = userService.findAllUserRole(page,limit,no,flag);
            int userCount = userService.findUserRoleCount();
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", userCount);
            map.put("data", list);

            return map;


    }

    @RequestMapping("userRoleDelete.do")
    public JsonBean UserRoleDelete(Integer id){

        userService.UserRoleDelete(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("/userRoleEdit.do")
    public JsonBean updateUser(Integer id, String[] rids){
        userService.updateUserRole(id, rids);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("findLeaders.do")
    public Collection<User> findLeaders(){

        Collection<User> list = userService.findLeaders();
        return list;

    }
}
