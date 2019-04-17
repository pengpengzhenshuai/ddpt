package com.qianfeng.dao;

import com.qianfeng.entity.Authority;
import com.qianfeng.vo.VMenuInfo;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);


    /**
     * 根据用户id获取权限  进行展示
     * @param id
     *      用户id
     * @return
     */
    public List<VMenuInfo> findAuthorityAll(int id);
}