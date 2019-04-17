package com.qianfeng.service.impl;

import com.qianfeng.dao.GradeMapper;
import com.qianfeng.dao.StudentMapper;
import com.qianfeng.entity.Grade;
import com.qianfeng.entity.Student;
import com.qianfeng.service.StudentService;
import com.qianfeng.vo.VStudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentMapper studentDao;

    @Override
    public List<VStudentInfo> findAllList() {

        List<VStudentInfo> list = studentDao.findAll();

        return list;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addVStudent(student);
    }

    @Override
    public void deleteStudent(String no) {
        studentDao.deleteStudent(no);
    }


}
