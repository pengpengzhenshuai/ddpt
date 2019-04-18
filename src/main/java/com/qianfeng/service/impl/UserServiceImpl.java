package com.qianfeng.service.impl;

import com.qianfeng.dao.RoleMapper;
import com.qianfeng.dao.UserMapper;
import com.qianfeng.dao.UserRoleMapper;
import com.qianfeng.entity.Role;
import com.qianfeng.entity.User;
import com.qianfeng.entity.UserRoleKey;
import com.qianfeng.service.UserService;
import com.qianfeng.vo.VUserRoleInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public User findPwdByNo(String no) {

        return null;
    }

    @Override
    public List<VUserRoleInfo> findAllUserRole(int page, int limit, String no, Integer flag) {
        List<VUserRoleInfo> list = null;
        int start = (page - 1) * limit;
        try {

            list = userMapper.findAllUserRole(start, limit, no , flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findUserRoleCount() {
        int count = 0;
        try {
           count = userMapper.findUserRoleCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void UserRoleDelete(Integer id) {

        try {
            userMapper.UserRoleDelete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserRole(Integer id, String[] rids) {

        List<UserRoleKey> userRoleList = userRoleMapper.findUserRole(id);
        List<Integer> ridList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < userRoleList.size(); i++){
            list.add(userRoleList.get(i).getRid());
        }
        //转化为集合
        for (int i = 0; i < rids.length; i++){

               ridList.add(Integer.parseInt(rids[i]));
        }

        if (list.size() == ridList.size()){
            /**
             * 这是数量相同时如果查询出的包含所有传入的，直接返回
             */
            if (list.containsAll(ridList)){
                return;
            }


            for (int i = 0; i < list.size(); i++){
                if(!ridList.contains(list.get(i))){
                    userRoleMapper.deleteUserRole(id, list.get(i));
                }
                if(!list.contains(ridList.get(i))){
                    userRoleMapper.addUserRole(id, ridList.get(i));
                }
            }
        }
        /**
         * 查询出数据库总用户角色数量比传来的用户角色数量多或相等时
         */
        else if(list.size() < ridList.size()){

            /**
             * 如果查出的数量小于所有传入的，传入的删除包含查询的所有元素，
             * 删除两集合的交集，
             * 执行添加操作，添加数据库中未有的角色权限
             */
            for(int i = 0; i < list.size(); i++){
                if(!ridList.contains(list.get(i))){
                    userRoleMapper.deleteUserRole(id, list.get(i));
                }
            }
            ridList.removeAll(list);
            Object[] rid  =ridList.toArray();
            for (int i = 0; i < rid.length; i++) {
                userRoleMapper.addUserRole(id, (Integer) rid[i]);
            }

            /**
             * 如果查出的数量大于于所有传入的，查询的删除包含传入的所有元素，
             * 删除两集合的交集，
             * 执行删除操作，删除数据库多余的权限
             */
        } else if (list.size() > ridList.size()) {
            for(int i = 0; i < ridList.size(); i++){
                if (!list.contains(ridList.get(i))) {
                    userRoleMapper.addUserRole(id, ridList.get(i));
                }
            }
            list.removeAll(ridList);
            Object[] rid = list.toArray();
            for (int i = 0; i < rid.length; i++) {
                userRoleMapper.deleteUserRole(id, (Integer) rid[i]);
            }

        }

    }

    @Override
    public Collection<User> findLeaders() {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List <Role> listLeadersId =  roleMapper.findMyRole(user.getId());


        List<User>  userMe = null;
        for (int i = 0; i < listLeadersId.size(); i++){
           if (listLeadersId.get(i).getParentid() == 0){
               userMe = userMapper.findLeaders(2);
           }

       }
        for (int i = 0; i < listLeadersId.size(); i++){
            if (userMe.get(i).getId() == user.getId()){
                userMe.remove(userMe.get(i));
                return userMe;
            }
        }


        Set<User> list = new HashSet<>();
        for (int i = 0; i < listLeadersId.size(); i++){

                try {
                    List<User>  userList = userMapper.findLeaders(listLeadersId.get(i).getParentid());
                   if (userList.get(i).getId() == user.getId()){
                       userList.remove(userList.get(i));
                   }
                    list.addAll(userList);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

        return list;
    }


}
