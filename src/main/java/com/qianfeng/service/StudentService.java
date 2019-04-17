package com.qianfeng.service;

import com.qianfeng.entity.Grade;
import com.qianfeng.entity.Student;
import com.qianfeng.vo.VStudentInfo;

import java.util.List;

public interface  StudentService {

    public List<VStudentInfo> findAllList();

    public void addStudent(Student student);

    public void deleteStudent(String no);
}
