package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.User;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenuInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/Menu.do")
    public JsonBean findAuthorityAll(HttpServletRequest request){

//晚上搜索的方法  可以保存session
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        List<VMenuInfo> list = authorityService.findAuthorityAll(user.getId());
        return JsonUtils.createJsonBean(1,list);
    }
}
