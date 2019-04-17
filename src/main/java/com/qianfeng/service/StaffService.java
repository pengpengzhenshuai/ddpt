package com.qianfeng.service;

import com.qianfeng.entity.Staff;
import com.qianfeng.vo.Vstaff;

import java.util.List;

public interface StaffService {

    //展示所有
    public List<Vstaff> findAll();

  //删除
    public  void delStaff(String no);

    //编辑
    public void updateStaff(Staff staff);

    //添加
    public void addStaff(Staff staff);
}
