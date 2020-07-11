package com.hl.vuewe.service;

import java.util.List;
import java.util.Map;

import com.hl.vuewe.entity.UserInfo;
import org.apache.commons.lang3.StringUtils;

public interface UserInfoService{

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserInfo record);
    /**
     * insertOrUpdate
     * @param record record
     * @return int
     */
    int insertOrUpdate(UserInfo record);
    /**
     * insertOrUpdateSelective
     * @param record record
     * @return int
     */
    int insertOrUpdateSelective(UserInfo record);
    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserInfo record);
    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserInfo selectByPrimaryKey(Integer id);
    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserInfo record);
    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserInfo record);
    /**
     * updateBatch
     * @param list list
     * @return int
     */
    int updateBatch(List<UserInfo> list);
    /**
     * updateBatchSelective
     * @param list list
     * @return int
     */
    int updateBatchSelective(List<UserInfo> list);
    /**
     * batchInsert
     * @param list list
     * @return int
     */
    int batchInsert(List<UserInfo> list);

    /**
     * selectInfoFromUseName
     * @param map map
     * @return UserInfo
     */
    UserInfo selectInfoFromUseName(Map<String,Object> map);

    /**
     * selectInfoFromEmail
     * @param map map
     * @return UserInfo
     */
    UserInfo selectInfoFromEmail(Map<String,Object> map);

    /**
     * checkUserFromUserName
     * @param userName userName
     * @return UserInfo
     */
    UserInfo checkUserFromUserName(String userName);

    /**
     * checkUserFromUserName
     * @param email userName
     * @return UserInfo
     */
    UserInfo checkUserFromEmail(String email);


}
