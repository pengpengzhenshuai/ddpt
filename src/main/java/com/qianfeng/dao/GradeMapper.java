package com.qianfeng.dao;

import com.qianfeng.entity.Grade;
import com.qianfeng.vo.VGradeInfo;
import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    /*                自己添加     */
    public List<VGradeInfo> findAllGrades();

    public void deleteGrade(Integer id);


    /**
     * 这是学生时需要年级列表
     */
    public List<Grade> findGrade();
}