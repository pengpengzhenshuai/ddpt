package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Course;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenuInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course/list.do")
    public Map<String, Object> courseList(int page){
        PageHelper.startPage(page, 10);
        Map<String, Object> map = new HashMap<>();
        try {
            List<Course> list =  courseService.findAllList();
            long total = ((Page)list).getTotal();
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
    @RequestMapping("course/addCourse.do")
    public void addCourse(Course course,HttpServletRequest request, HttpServletResponse response) {


        try {
            courseService.addCourseList(course);
            response.sendRedirect(request.getContextPath() + "/courselist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("course/deleteCourse.do")
    public JsonBean deleteCourse(int id) {

        courseService.deleteCourse(id);
        return  JsonUtils.createJsonBean(1,null);

    }

    @RequestMapping("course/updateCourse.do")
    public void updeteCourse(Course course, HttpServletRequest request, HttpServletResponse response) {

        try {
            courseService.updateCourse(course);
            response.sendRedirect(request.getContextPath() + "/courselist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
