package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.DataDictionary;
import com.orangeSoft.market.pojo.DataDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {
    long countByExample(DataDictionaryExample example);

    int deleteByExample(DataDictionaryExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryExample example);

    DataDictionary selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") DataDictionary record, @Param("example") DataDictionaryExample example);

    int updateByExample(@Param("record") DataDictionary record, @Param("example") DataDictionaryExample example);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}