package com.qianfeng.dao;

import com.qianfeng.entity.Role;
import com.qianfeng.entity.UserRoleKey;
import com.qianfeng.entity.depart;
import com.qianfeng.vo.VUserRoleInfo;
import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(Role record);

    int insertSelective(UserRoleKey record);

    int updateByPrimaryKey(Role record);
    //用户角色展示
    public List<VUserRoleInfo> findAllRole();
    //用户角色删除
    public void deleteRole(Integer id);
     //查询
    //public  List<UserRoleKey> searchByCondition(int no ,int flag);

    //编辑
    public void updateUserRole(UserRoleKey userRoleKey);
}