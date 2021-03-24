package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.OrderLogistics;
import com.orangeSoft.market.entity.OrderStateflow;
import com.orangeSoft.market.mapper.OrderStateflowMapper;
import com.orangeSoft.market.service.IOrderStateflowService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class OrderStateflowServiceImpl extends ServiceImpl<OrderStateflowMapper, OrderStateflow> implements IOrderStateflowService {

    @Override
    public Result.JSONResultMap updateOrderStateflow(long orderId, long recordId) {
        OrderStateflow orderStateflow = new OrderStateflow();
        orderStateflow.setOrderId(orderId);
        orderStateflow.setRecordId(recordId);
        orderStateflow.setStatusDate(LocalDateTime.now());
        try {
            this.save(orderStateflow);
            return Result.success();
        } catch (DuplicateKeyException duplicateKeyException) {
            return Result.fail();
        }
    }

    @Override
    public Result.JSONResultMap updateOrderStateflow(long orderId, long recordId, int logisticsId) {
        OrderLogistics orderLogistics = new OrderLogistics();
        orderLogistics.setLogisticsId(logisticsId);
        orderLogistics.setOrderId(orderId);
        if ((new OrderLogisticsServiceImpl().save(orderLogistics)) && (boolean) updateOrderStateflow(orderId, recordId).get("success")) {
            return Result.success();
        }
        return Result.fail();
    }
}
