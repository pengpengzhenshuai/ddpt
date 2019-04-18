package com.qianfeng.service.impl;

import com.qianfeng.dao.AuthorityMapper;
import com.qianfeng.entity.Authority;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.vo.VMenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public List<VMenuInfo> findAuthorityAll(int id) {
        List<VMenuInfo>  list = null;
        try {
            list = authorityMapper.findAuthorityAll(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Authority> findAll(int page, int limit) {
        List<Authority> list = null;
        int start = (page - 1) * limit;
        try {
           list = authorityMapper.findAll(start, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findAuthorityCount() {
        int count = 0;
        try {
            count = authorityMapper.findAuthorityCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Authority> findAuthorityAllOne() {
        List<Authority> list = null;
        try {
            list = authorityMapper.findAuthorityAllOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int insertSelective(Authority record) {
        Authority authority = authorityMapper.findByTitle(record.getTitle());
        if (authority != null){
            return -1;
        }

        try {
            authorityMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        try {
            int a = authorityMapper.deleteByPrimaryKey(id);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return  -1;
        }

    }


}
