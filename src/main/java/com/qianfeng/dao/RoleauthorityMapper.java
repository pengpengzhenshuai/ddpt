package com.qianfeng.dao;

import com.qianfeng.entity.RoleauthorityKey;

public interface RoleauthorityMapper {
    int deleteByPrimaryKey(RoleauthorityKey key);

    int insert(RoleauthorityKey record);

    int insertSelective(RoleauthorityKey record);
}