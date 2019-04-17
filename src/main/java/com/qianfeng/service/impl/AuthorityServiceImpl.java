package com.qianfeng.service.impl;

import com.qianfeng.dao.AuthorityMapper;
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
}
