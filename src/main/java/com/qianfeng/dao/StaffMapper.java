package com.qianfeng.dao;

import com.qianfeng.entity.Staff;
import com.qianfeng.vo.Vstaff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String no);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    //展示所有
    public List<Vstaff> findAll();
    //删除
    public  void delStaff(String on);
    //编辑
    public  void updateStaff(Staff staff);
    //添加
    public  void  addStaff(Staff staff);


}