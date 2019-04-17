package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Grade;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class GradeController {
    @Autowired
    private GradeService gradeService;


    @RequestMapping("/grade/list.do")
    public Map<String,Object> findByAll(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = gradeService.findGradeAll(page, pageSize);

        return map;
    }
/*    这是用于学生的方法*/
    @RequestMapping("/grade/list1.do")
    public List findBylist(){
        List<Grade> list = gradeService.findAllGrade();
        return list;
    }
    @RequestMapping("/grade/delete.do")
    public JsonBean deleteGradeById(Integer id){

        try {
            gradeService.deleteGradeById(id);
            return JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }

    @RequestMapping("/grade/update.do")
    public JsonBean updateGrade(Grade grade){
        gradeService.updateGrade(grade);
        return JsonUtils.createJsonBean(1,null);
    }
    @RequestMapping("/grade/add.do")
    public JsonBean addGrade(Grade grade){
        grade.setCid(1);
        grade.setFlag(1);
        gradeService.addGrade(grade);
        return JsonUtils.createJsonBean(1,null);
    }

}
