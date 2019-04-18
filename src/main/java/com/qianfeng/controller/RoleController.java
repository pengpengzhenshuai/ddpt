package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VRolePower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/roleList.do")
    public Map<String, Object> selectRoleAll(int page, int limit, String no, Integer flag){
        List<VRolePower> list = roleService.selectRoleAll(page, limit, no, flag);
        int count = roleService.selectRoleCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0); // 0 表示成功
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/allRole.do")
    public List<Role> selectAll(){

        List<Role> list = roleService.selectAll();
        return list;
    }

    @RequestMapping("/roleFalseDelete.do")
    public JsonBean roleFalseDelete(Integer id){

        roleService.roleFalseDelete(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("roleAuthorityUpdate.do")
    public JsonBean updateRoleAuthority(int id, String[] rids){

        roleService.updateRoleAuthority(id, rids);
        return  JsonUtils.createJsonBean(1000,null);
    }
}
