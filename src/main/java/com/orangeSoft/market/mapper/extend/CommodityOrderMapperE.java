package com.orangeSoft.market.mapper.extend;

import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityOrderMapperE extends com.orangeSoft.market.mapper.CommodityOrderMapper {
    OrderDetailResult findOrderDetailByOrderId(@Param("orderId") long orderId);
    List<UserOrderResult> findUserOrderByUserId(@Param("uid") Integer uid);
}
