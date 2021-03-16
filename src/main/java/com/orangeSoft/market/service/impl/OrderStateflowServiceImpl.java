package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.OrderStateflow;
import com.orangeSoft.market.mapper.OrderStateflowMapper;
import com.orangeSoft.market.service.IOrderStateflowService;
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
        if(this.save(orderStateflow)){
            return Result.success();
        }
        return Result.fail();
    }
}
