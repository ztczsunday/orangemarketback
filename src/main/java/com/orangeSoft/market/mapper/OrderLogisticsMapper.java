package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.OrderLogisticsExample;
import com.orangeSoft.market.pojo.OrderLogisticsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLogisticsMapper {
    long countByExample(OrderLogisticsExample example);

    int deleteByExample(OrderLogisticsExample example);

    int deleteByPrimaryKey(OrderLogisticsKey key);

    int insert(OrderLogisticsKey record);

    int insertSelective(OrderLogisticsKey record);

    List<OrderLogisticsKey> selectByExample(OrderLogisticsExample example);

    int updateByExampleSelective(@Param("record") OrderLogisticsKey record, @Param("example") OrderLogisticsExample example);

    int updateByExample(@Param("record") OrderLogisticsKey record, @Param("example") OrderLogisticsExample example);
}