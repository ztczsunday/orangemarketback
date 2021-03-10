package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.OrderStateflow;
import com.orangeSoft.market.pojo.OrderStateflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStateflowMapper {
    long countByExample(OrderStateflowExample example);

    int deleteByExample(OrderStateflowExample example);

    int insert(OrderStateflow record);

    int insertSelective(OrderStateflow record);

    List<OrderStateflow> selectByExample(OrderStateflowExample example);

    int updateByExampleSelective(@Param("record") OrderStateflow record, @Param("example") OrderStateflowExample example);

    int updateByExample(@Param("record") OrderStateflow record, @Param("example") OrderStateflowExample example);
}