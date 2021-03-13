package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface CommodityOrderMapper extends BaseMapper<CommodityOrder> {

    OrderDetailResult findOrderDetailByOrderId(long orderId);

    List<UserOrderResult> findUserOrderByUserId(Integer uid);
}
