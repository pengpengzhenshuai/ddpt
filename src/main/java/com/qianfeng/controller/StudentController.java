package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Course;
import com.qianfeng.entity.Grade;
import com.qianfeng.entity.Student;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStudentInfo;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentList.do")
    public Map<String, Object> courseList(int page){
        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();
        try {
            List<VStudentInfo> list = studentService.findAllList();
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

    @RequestMapping("/student/updateStudent.do")
    public void updateStudent(Student student,HttpServletRequest request, HttpServletResponse response) {


        try {
            studentService.addStudent(student);
            response.sendRedirect(request.getContextPath() + "/studentlist.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/student/deleteCourse.do")
    public JsonBean deleteCourse(String no) {

        studentService.deleteStudent(no);
        return  JsonUtils.createJsonBean(1,null);

    }
}
