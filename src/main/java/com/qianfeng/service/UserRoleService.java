package com.qianfeng.service;


import com.qianfeng.entity.Role;
import com.qianfeng.entity.UserRoleKey;

import java.util.List;
import java.util.Map;

public interface UserRoleService {


    public Map<String,Object> findRoleAll(Integer page, Integer pageSize);

    public List<UserRoleKey> select();

    public void deleteById(Integer id);

    public void update(Role role);

    public void add(Role role);

}
