package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Manager;

/**
 * <p>
 * 管理员专用账户 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IManagerService extends IService<Manager> {
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

    Result.JSONResultMap managerLogin(String adminAccount, String adminPassword);
}
