package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.depart;
import com.qianfeng.service.DepartService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @RequestMapping("/departList.do")
    public Map<String, Object> departList(Integer page) {
        PageHelper.startPage(page, 10);
        Map<String, Object> map = new HashMap<>();
        try {
            List<depart> list = departService.findAllDepart();
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

    @RequestMapping("/findAllDept.do")
    public  List  findAllDepart() {
        List<depart> list = departService.findAllDepart();;
        return list;
    }

    @RequestMapping("/departdelete.do")
    public JsonBean delDepart(Integer id) {
        departService.delDepart(id);
        return JsonUtils.createJsonBean(1,null);
    }

    @RequestMapping("/departupdate.do")
    public  void  updateDepart(depart depart, HttpServletRequest request, HttpServletResponse response) {

        try {
            departService.updateDepartInfo(depart);
            response.sendRedirect(request.getContextPath()+"/departlist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   @RequestMapping("/departadd.do")
    public  void  addDepart(depart depart, HttpServletRequest request, HttpServletResponse response) {

       try {
           departService.add(depart);
           response.sendRedirect(request.getContextPath()+"/departlist.html");
       } catch (Exception e) {
           e.printStackTrace();
       }

   }





}
