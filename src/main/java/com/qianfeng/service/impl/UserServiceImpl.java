package com.qianfeng.service.impl;

import com.qianfeng.dao.UserMapper;
import com.qianfeng.entity.User;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VUserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User findPwdByNo(String no) {

        return null;
    }

    @Override
    public List<VUserRoleInfo> findAllUserRole() {
        List<VUserRoleInfo> list = null;
        try {
            list = userMapper.findAllUserRole();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
