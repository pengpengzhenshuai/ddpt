package com.qianfeng.service;

import com.qianfeng.entity.depart;

import java.util.List;

public interface DepartService {

    public List<depart> findAllDepart();

    public void delDepart(Integer id);

    public  void  updateDepartInfo(depart depart);

    public void  add(depart depart);


}
