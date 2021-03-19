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
     * 订单状态更改
     *
     * @param orderId  订单ID
     * @param recordId 订单状态ID
     * @return 更改是否成功
     */
    Result.JSONResultMap updateOrderStateflow(long orderId, long recordId);

    /**
     * 订单状态更改（发货）
     *
     * @param orderId     订单ID
     * @param recordId    订单状态ID
     * @param logisticsId 物流ID
     * @return 更改是否成功
     */
    Result.JSONResultMap updateOrderStateflow(long orderId, long recordId, int logisticsId);
}
