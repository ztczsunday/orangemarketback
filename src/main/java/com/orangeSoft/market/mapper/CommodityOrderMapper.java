package com.orangeSoft.market.mapper;

import com.orangeSoft.market.common.pojo.CommodityOrder;
import com.orangeSoft.market.common.pojo.CommodityOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityOrderMapper {
    long countByExample(CommodityOrderExample example);

    int deleteByExample(CommodityOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(CommodityOrder record);

    int insertSelective(CommodityOrder record);

    List<CommodityOrder> selectByExample(CommodityOrderExample example);

    CommodityOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByExample(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByPrimaryKeySelective(CommodityOrder record);

    int updateByPrimaryKey(CommodityOrder record);
}