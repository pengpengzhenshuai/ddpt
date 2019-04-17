package com.qianfeng.dao;

import com.qianfeng.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);



    /*                                  新增的                                        */

    /**
     * 展示所有的课程
     *  @param
     */
    public List<Course> findList();


    /**
     * 添加新的科目
     * @param course
     */
    public void addCourse(Course course);

    /**
     * 删除
     * @param id
     */

    public  void deleteCourse(int id);

    /**
     * 修改
     * @param course
     */

    public void updateCourse(Course course);


}