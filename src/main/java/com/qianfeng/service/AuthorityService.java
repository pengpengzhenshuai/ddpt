package com.qianfeng.service;

import com.qianfeng.vo.VMenuInfo;


import java.util.List;

public interface AuthorityService  {
    /**
     * 根据用户id获取权限
     * @param id
     *      用户id
     * @return
     */
    public List<VMenuInfo> findAuthorityAll(int id);
}
