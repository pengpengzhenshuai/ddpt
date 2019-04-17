package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.entity.Check;
import com.qianfeng.entity.depart;
import com.qianfeng.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("/processlist.do")
    public Map<String, Object> CheckList(Integer page) {
        PageHelper.startPage(page, 10);
        Map<String, Object> map = new HashMap<>();
        try {
         List<Check> list =  checkService.findAll();
            long total = ((Page) list).getTotal();
        /*response.sendRedirect(request.getContextPath() + "/index.html");*/
            System.out.println("sdfsfd");
            map.put("code", 0); // 0 表示成功
            map.put("msg", "");
            map.put("count", total);
            map.put("data", list);

            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        }

    }
}
