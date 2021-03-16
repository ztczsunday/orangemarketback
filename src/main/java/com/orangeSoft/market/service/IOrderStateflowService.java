package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.OrderStateflow;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IOrderStateflowService extends IService<OrderStateflow> {

    /**
     *
     * @param orderId 订单ID
     * @param recordId 订单状态ID
     * @return 添加指定订单状态
     */
    Result.JSONResultMap updateOrderStateflow(long orderId, long recordId);
}
