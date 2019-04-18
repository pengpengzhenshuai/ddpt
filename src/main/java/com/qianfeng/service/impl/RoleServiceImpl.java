package com.qianfeng.service.impl;

import com.qianfeng.dao.AuthorityMapper;
import com.qianfeng.dao.RoleMapper;
import com.qianfeng.entity.Authority;
import com.qianfeng.entity.Role;
import com.qianfeng.service.RoleService;
import com.qianfeng.vo.VRolePower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public List<VRolePower> selectRoleAll(int page, int limit, String no, Integer flag) {

        List<VRolePower> list = null;
        int start = (page - 1) * limit;
        try {
            list = roleMapper.selectRoleAll(start, limit, no, flag);

            for (int i = 0; i < list.size(); i++) {
               List<Authority> aList = authorityMapper.findOneAuthorityByRoleId(list.get(i).getId());
               list.get(i).setAuthorityList(aList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectRoleCount() {
        int count = 0;
        try {
            count = roleMapper.selectRoleCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Role> selectAll() {

        List<Role> list = null;
        try {
            list = roleMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void roleFalseDelete(Integer id) {
        roleMapper.roleFalseDelete(id);
    }

    @Override
    public void updateRoleAuthority(int id, String[] rids) {


        roleMapper.deleteRoleAuthorityByRid(id);
        if(rids.length != 0 ){
            for (int i = 0; i < rids.length ; i++) {
               List<Authority> list = authorityMapper.findRoleSecondAuthority(Integer.parseInt(rids[i]));
                int [] array = new int[list.size()];
                for (int j = 0; j < list.size() ; j++){
                   array[j] = list.get(j).getId();
                }

               roleMapper.addRoleAuthority(id , Integer.parseInt(rids[i]), array);

            }
        }

    }

}
