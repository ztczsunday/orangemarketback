package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.pojo.ShopOrderResult;
import com.orangeSoft.market.pojo.UserOrderResult;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface ICommodityOrderService extends IService<CommodityOrder> {

    /**
     * @param orderId 目标订单
     * @return 目标订单详情
     */
    Result.JSONResultMap findOrderDetailByOrderId(long orderId);

    /**
     * @param page 用户订单分页
     * @return 与买家用户有关的订单
     */
    Result.JSONResultMap findUserOrderByUid(Page<UserOrderResult> page);

    /**
     * @param subId            商品种类ID
     * @param receiveAddressId 收货地址ID
     * @param countCommodity   购买总数
     * @param orderLogisticsId 选择物流ID
     * @return 订单是否创建成功
     */
    Result.JSONResultMap addOrder(int subId, int receiveAddressId, int countCommodity, int orderLogisticsId);

    /**
     * @param page 用户订单分页
     * @return 与卖家用户有关的订单
     */
    Result.JSONResultMap findShopOrderByUid(Page<ShopOrderResult> page);
}
