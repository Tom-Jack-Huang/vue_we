package com.hl.vuewe.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hl.vuewe.entity.Peo;
import com.hl.vuewe.mapper.PeoMapper;
import com.hl.vuewe.service.PeoService;
@Service
public class PeoServiceImpl implements PeoService{

    @Resource
    private PeoMapper peoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return peoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Peo record) {
        return peoMapper.insert(record);
    }

    @Override
    public int insertSelective(Peo record) {
        return peoMapper.insertSelective(record);
    }

    @Override
    public Peo selectByPrimaryKey(Integer id) {
        return peoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Peo record) {
        return peoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Peo record) {
        return peoMapper.updateByPrimaryKey(record);
    }

}
