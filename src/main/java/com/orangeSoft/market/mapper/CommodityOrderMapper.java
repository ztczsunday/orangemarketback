package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.pojo.ShopOrderResult;
import com.orangeSoft.market.pojo.UserOrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface CommodityOrderMapper extends BaseMapper<CommodityOrder> {

    UserOrderDetailResult findOrderDetailByOrderId(@Param("orderId") long orderId);

    IPage<UserOrderResult> findUserOrderByUserId(@Param("uid") Integer uid, IPage<UserOrderResult> page);

    int findSidBySubId(Integer subId);

    IPage<ShopOrderResult> findShopOrderBySid(@Param("sid") Integer sid, IPage<ShopOrderResult> page);
}
