package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginOutController {

   //注销
    @RequestMapping("/out.do")
    public JsonBean outlogin(HttpSession session) {

        session.invalidate();

        return JsonUtils.createJsonBean(1, null);
    }

/*
    //注销
    @RequestMapping("/out.do")
    public void outlogin2( HttpServletRequest request, HttpServletResponse response,HttpSession session) {


        try {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
