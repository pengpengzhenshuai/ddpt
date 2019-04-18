package com.qianfeng.dao;

import com.qianfeng.entity.Role;
import com.qianfeng.vo.VRolePower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     *  获取所有角色信息分页和条件查询
     * @return
     */
    List<VRolePower> selectRoleAll(@Param("start") int start, @Param("limit") int limit, @Param("name") String no, @Param("flag") Integer flag);

    /**
     *  获取所有角色总数
     * @return
     */
    int selectRoleCount();

    /**
     * 获取有效的所有的角色信息
     * @return
     */
    List<Role> selectAll();

    /**
     * 通过改变角色状态达到假删除角色
     * @param id
     *      角色id
     */
    void roleFalseDelete(Integer id);

    /**
     * 获得我的角色信息
     * @param id
     * @return
     */
    List<Role> findMyRole(int id);

    /**
     * 添加角色权限
     * @param rid
     * @param aid
     * @param array
     */
    void addRoleAuthority(@Param("rid") int rid, @Param("aid") int aid, @Param("array") int[] array);

    /**
     * 通过权限id删除角色权限
     * @param aid
     */
    void deleteRoleAuthorityByAid(int aid);

    /**
     *  通过角色id删除角色权限
     * @param rid
     */
    void deleteRoleAuthorityByRid(int rid);

}