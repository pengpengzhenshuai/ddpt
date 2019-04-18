package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Authority;
import com.qianfeng.entity.User;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenuInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    /**
     *  根据用户id获取其拥有的权限
     * @return
     *
     */
    @RequestMapping("/Menu.do")
    public JsonBean findAuthorityAll(){


        User user = (User) SecurityUtils.getSubject().getPrincipal();

        List<VMenuInfo> list = authorityService.findAuthorityAll(user.getId());
        return JsonUtils.createJsonBean(1,list);
    }

    /**
     * 获取所有的权限（资源）信息
     * @return
     */
    @RequestMapping("/authorityList.do")
    public Map<String, Object> findAll(int page,int limit){
        List<Authority> list = authorityService.findAll(page, limit);
        int count = authorityService.findAuthorityCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);

        return map;
    }

    /**
     * 获取所有一级权限
     * @return
     */
    @RequestMapping("roleOneAll.do")
    public List<Authority> findAuthorityOneAll(){

        List<Authority> list = authorityService.findAuthorityAllOne();
        return list;
    }

    @RequestMapping("authorityAdd.do")
    public JsonBean insertSelective(Authority record){

        int a = authorityService.insertSelective(record);
        if (a == -1){
            return JsonUtils.createJsonBean(1000,null);
        } else {
            return JsonUtils.createJsonBean(1000,null);
        }

    }

    @RequestMapping("deleteAuthority.do")
    public JsonBean deleteByPrimaryKey(Integer id){
        int a = authorityService.deleteByPrimaryKey(id);
        if (a == -1){
            return JsonUtils.createJsonBean(1000,null);
        } else {
            return JsonUtils.createJsonBean(1000,null);
        }
    }
}
