package com.hl.vuewe.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hl.vuewe.mapper.UserInfoMapper;
import com.hl.vuewe.entity.UserInfo;
import com.hl.vuewe.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserInfo record) {
        return userInfoMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserInfo record) {
        return userInfoMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserInfo> list) {
        return userInfoMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserInfo> list) {
        return userInfoMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserInfo> list) {
        return userInfoMapper.batchInsert(list);
    }

    @Override
    public UserInfo selectInfoFromUseName(Map<String,Object> map) {
        return userInfoMapper.selectInfoFromUseName(map);
    }

    @Override
    public UserInfo selectInfoFromEmail(Map<String, Object> map) {
        return userInfoMapper.selectInfoFromEmail(map);
    }

    @Override
    public UserInfo checkUserFromUserName(String userName) {
        return userInfoMapper.checkUserFromUserName(userName);
    }

    @Override
    public UserInfo checkUserFromEmail(String email) {
        return userInfoMapper.checkUserFromEmail(email);
    }
}
