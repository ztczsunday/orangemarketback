package com.orangeSoft.market.mapper;

import com.orangeSoft.market.common.pojo.SubCommodity;
import com.orangeSoft.market.common.pojo.SubCommodityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubCommodityMapper {
    long countByExample(SubCommodityExample example);

    int deleteByExample(SubCommodityExample example);

    int deleteByPrimaryKey(Integer subId);

    int insert(SubCommodity record);

    int insertSelective(SubCommodity record);

    List<SubCommodity> selectByExample(SubCommodityExample example);

    SubCommodity selectByPrimaryKey(Integer subId);

    int updateByExampleSelective(@Param("record") SubCommodity record, @Param("example") SubCommodityExample example);

    int updateByExample(@Param("record") SubCommodity record, @Param("example") SubCommodityExample example);

    int updateByPrimaryKeySelective(SubCommodity record);

    int updateByPrimaryKey(SubCommodity record);
}