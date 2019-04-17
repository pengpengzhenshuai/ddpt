package com.qianfeng.dao;

import com.qianfeng.entity.Grade;
import com.qianfeng.entity.Student;
import com.qianfeng.vo.VStudentInfo;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String no);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

/*                                   自己添加                                                        */

    public List<VStudentInfo> findAll();

    /**
     * 实行添加
     * @param student
     */
    public void addVStudent(Student student);


    public void deleteStudent(String no);



}