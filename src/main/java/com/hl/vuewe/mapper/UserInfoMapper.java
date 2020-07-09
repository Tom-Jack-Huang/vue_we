package com.hl.vuewe.mapper;

import com.hl.vuewe.entity.UserInfo;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface UserInfoMapper {
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
    int batchInsert(@Param("list") List<UserInfo> list);
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
}