package com.qianfeng.service.impl;

import com.qianfeng.dao.CourseMapper;
import com.qianfeng.entity.Course;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseDao;

    @Override
    public List<Course> findAllList() {
        List<Course> list = courseDao.findList();
        return list;
    }

    @Override
    public void addCourseList(Course course) {

        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse(int id) {

        courseDao.deleteCourse(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }
}
