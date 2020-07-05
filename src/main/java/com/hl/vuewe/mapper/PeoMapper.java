package com.hl.vuewe.mapper;

import com.hl.vuewe.entity.Peo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeoMapper {
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
    int insert(Peo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Peo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Peo selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Peo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Peo record);
}