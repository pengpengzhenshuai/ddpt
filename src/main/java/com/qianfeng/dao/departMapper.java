package com.qianfeng.dao;

import com.qianfeng.entity.depart;
import java.util.List;




//  authority 权限表   check 记录表   contect 联系表  county 县级表
// address地址表  grade 成绩表   interviewquest 调查表   loginlog 登陆注销
// paper 证件表   province省级表
public interface departMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(depart record);

    int insertSelective(depart record);

    depart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(depart record);

    int updateByPrimaryKey(depart record);

    public List<depart> findAll();



    //删除
    public void delDepartById(Integer id);

    //编辑部门
    public void updateDepart(depart depart);

    //添加部门
    public  void add(depart depart);


}