package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.common.LayUIListJsonBean;
import com.qianfeng.entity.Staff;
import com.qianfeng.entity.depart;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.Vstaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/staffList.do")
    public Map<String, Object> courseList(Integer page) {

        PageHelper.startPage(page, 5);
        Map<String, Object> map = new HashMap<>();

        try {
            List<Vstaff> list = staffService.findAll();
            long total = ((Page) list).getTotal();
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


    @RequestMapping("/photoupload.do")
    public JsonBean upload(@RequestParam("file") MultipartFile upfile, HttpServletRequest request, HttpSession session){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取上传文件的文件名
        String fileName = upfile.getOriginalFilename();
        // 获得文件后缀名称
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称

        String newFileName = uuid + "."+ suffixName;
        System.out.println(newFileName);

        session.setAttribute("newFileName",newFileName);
        String path = request.getServletContext().getRealPath("/");
        System.out.println(path);
        File parentPath = new File(path);
        // 获取父级目录的路径
        path = parentPath.getParent() + "/webapp/media/images";

        System.out.println("path == " + path);

        File dirPath = new File(path);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
        //upfile.getInputStream()
        File file = new File(path, newFileName);


        try {
            // 保存文件
            upfile.transferTo(file);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return JsonUtils.createJsonBean(1,null);
    }


    @RequestMapping("/staffdelete.do")
    public JsonBean delStaff(String no){
        staffService.delStaff(no);
        return JsonUtils.createJsonBean(1,null);
    }


    @RequestMapping("/staffUpdate.do")
    public JsonBean updateStaff(Staff staff) {
        try {
            staffService.updateStaff(staff);
            return JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,null);
        }

    }

    @RequestMapping("/staffadd.do")
    public  JsonBean  addDepart(Staff staff) {
            staffService.addStaff(staff);
            return JsonUtils.createJsonBean(1,null);


    }




}