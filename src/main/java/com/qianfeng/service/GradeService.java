package com.qianfeng.service;

import com.qianfeng.entity.Grade;

import java.util.List;
import java.util.Map;

public interface GradeService {
   public Map<String,Object> findGradeAll(Integer page, Integer pageSize);
   public void deleteGradeById(Integer id);
   public void updateGrade(Grade grade);
   public void addGrade(Grade grade);


   public List<Grade> findAllGrade();
}
