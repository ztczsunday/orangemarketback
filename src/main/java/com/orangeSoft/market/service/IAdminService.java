package com.orangeSoft.market.service;

import com.orangeSoft.market.common.utils.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-19
 */
public interface IAdminService {
    /**
     * 查看用户总量
     *
     * @return 用户总数
     */
    Result.JSONResultMap findUserAmount();

    /**
     * 查看各个状态的订单数
     *
     * @return 各个状态的订单数
     */
    Result.JSONResultMap findOrderStatus();

    /**
     * 查看商品好评率
     *
     * @return 订单好评数与总数
     */
    Result.JSONResultMap findCommodityPraise();

    /**
     * 查看每天订单量
     *
     * @param days     查询天数
     * @param recordId 查询订单状态
     * @return 每天订单量
     */
    Result.JSONResultMap findEverydayOrderAmount(int days, int recordId);
}
