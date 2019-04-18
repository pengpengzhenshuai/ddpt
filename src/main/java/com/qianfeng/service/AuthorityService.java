package com.qianfeng.service;

import com.qianfeng.entity.Authority;
import com.qianfeng.vo.VMenuInfo;

import java.util.List;

public interface AuthorityService {
    /**
     * 根据用户id获取权限
     * @param id
     *      用户id
     * @return
     */
    public List<VMenuInfo> findAuthorityAll(int id);

    /**
     * 获取所有权限信息
     * @return
     *      成功返回权限集合，失败为null
     */
    List<Authority> findAll(int page, int limit);

    /**
     * 获取所有权限总数
     * @return
     *      成功返回总数，失败返回0
     */
    int findAuthorityCount();

    /**
     * 获取所有一级权限
     * @return
     */
    List<Authority> findAuthorityAllOne();

    /**
     * 添加权限
     * @param record
     * @return
     */
    int insertSelective(Authority record);

    int deleteByPrimaryKey(Integer id);
}
