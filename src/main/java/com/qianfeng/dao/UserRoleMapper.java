package com.qianfeng.dao;

import com.qianfeng.entity.UserRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    void updateUserRole(@Param("uid") Integer id, @Param("rid") Integer rid);

    void deleteUserRole(@Param("uid") Integer id, @Param("rid") Integer rid);

    /**
     * 根据传来用户id查询其所有角色
     * @param id
     *      用户id
     * @return
     */
    List<UserRoleKey> findUserRole(Integer id);

    /**
     *  给指定用户添加角色
     * @param uid
     *      指定用户id
     * @param rid
     *      角色id
     */
    void addUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
}