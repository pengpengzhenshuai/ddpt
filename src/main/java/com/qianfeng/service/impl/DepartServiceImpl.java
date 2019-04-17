package com.qianfeng.service.impl;

import com.qianfeng.entity.depart;
import com.qianfeng.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private com.qianfeng.dao.departMapper departMapper;
    @Override
    public List<depart> findAllDepart() {
        List<depart> list =null;
        try {
            list = departMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

    @Override
    public void delDepart(Integer id) {

        try {
          departMapper.delDepartById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartInfo(depart depart) {
        try {
            departMapper.updateDepart(depart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(depart depart) {

        try {
            departMapper.add(depart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
