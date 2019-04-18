package com.qianfeng.service;


import com.qianfeng.entity.User;
import com.qianfeng.vo.VUserRoleInfo;

import java.util.Collection;
import java.util.List;


public interface UserService {

    /**
     *
     * 根据工号查询用户信息
     * @param no
     *      工号
     * @return
     *      成功返回User对象，失败null
     */
    public User findPwdByNo(String no);

    /**
     * 获取所有用户角色信息
     * @return
     */
    public List<VUserRoleInfo> findAllUserRole(int page, int limit, String no, Integer flag);

    /**
     *  获取用户人数
     * @return
     *      成功返回总人数,失败返回0
     */
    public int findUserRoleCount();

    /**
     * 删除用户角色
     */
    void UserRoleDelete(Integer id);

    /**
     * 修改用户角色
     * @param uid
     * @param rids
     */
    void updateUserRole(Integer uid, String[] rids);

    /**
     * 获取上一级领导
     * @return
     */
    Collection<User> findLeaders();


}
