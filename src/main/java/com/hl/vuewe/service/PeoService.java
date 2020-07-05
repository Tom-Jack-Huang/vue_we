package com.hl.vuewe.service;

import com.hl.vuewe.entity.Peo;
public interface PeoService{


    int deleteByPrimaryKey(Integer id);

    int insert(Peo record);

    int insertSelective(Peo record);

    Peo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Peo record);

    int updateByPrimaryKey(Peo record);

}
