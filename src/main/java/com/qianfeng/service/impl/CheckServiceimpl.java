package com.qianfeng.service.impl;

import com.qianfeng.dao.CheckMapper;
import com.qianfeng.entity.Check;
import com.qianfeng.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceimpl implements CheckService {
    @Autowired
    private CheckMapper checkMapper;
    @Override
    public List<Check> findAll() {
        List<Check> list =null;
        try {
         list = checkMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
