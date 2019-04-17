package com.qianfeng.service;

import com.qianfeng.entity.Course;

import java.util.List;

public interface CourseService {


    public List<Course> findAllList();

    public  void addCourseList(Course course);

    public  void deleteCourse(int id);

    public  void updateCourse(Course course);
}
