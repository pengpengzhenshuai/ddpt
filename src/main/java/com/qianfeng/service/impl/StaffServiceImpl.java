package com.qianfeng.service.impl;

import com.qianfeng.dao.StaffMapper;
import com.qianfeng.entity.Staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.vo.Vstaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;


    @Override
    public List<Vstaff> findAll() {

        List<Vstaff> list = null;
        try {
            list = staffMapper.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delStaff(String no) {
        try {
            staffMapper.delStaff(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStaff(Staff staff) {
        try {
            staffMapper.updateStaff(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStaff(Staff staff) {
        try {
            staffMapper.addStaff(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
