package com.qianfeng.dao;

import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.vo.VUserRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

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
    public List<VUserRoleInfo> findAllUserRole(@Param("start") int start, @Param("limit") int limit, @Param("no") String no, @Param("flag") Integer flag);

    /**
     *  获取用户人数
     * @return
     *      成功返回总人数，失败返回0
     */

    public int findUserRoleCount();

    /**
     * 删除用户角色
     */
    void UserRoleDelete(Integer id);

    /**
     * 获取上一级领导
     * @param id
     * @return
     */
    List<User> findLeaders(int id);

    /**
     * 获得我的角色信息
     * @param id
     * @return
     */
    Role findMyRole(int id);
}