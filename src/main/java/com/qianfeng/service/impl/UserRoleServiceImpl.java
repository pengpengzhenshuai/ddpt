package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.UserRoleMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.UserRoleKey;
import com.qianfeng.service.UserRoleService;
import com.qianfeng.vo.VUserRoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    public UserRoleMapper userRoleMapper;

    @Override
    public Map<String, Object> findRoleAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<VUserRoleInfo> list = userRoleMapper.findAllRole();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page) list).getTotal();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @Override
    public List<UserRoleKey> select() {

return null;
    }

    @Override
    public void deleteById(Integer id) {

        try {
            userRoleMapper.deleteRole(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Role role) {

        userRoleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void add(Role role) {

        userRoleMapper.insert(role);
    }
}
