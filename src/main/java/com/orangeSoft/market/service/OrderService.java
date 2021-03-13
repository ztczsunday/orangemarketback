package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.extend.CommodityOrderMapperE;
import com.orangeSoft.market.mapper.extend.OrderLogisticsMapperE;
import com.orangeSoft.market.mapper.extend.OrderStateflowMapperE;
import com.orangeSoft.market.common.pojo.*;
import com.orangeSoft.market.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    CommodityOrderMapperE commodityOrderMapperE;
    @Autowired
    OrderStateflowMapperE orderStateflowMapperE;
    @Autowired
    OrderLogisticsMapperE orderLogisticsMapperE;

    public Result.JSONResultMap findOrderByUid(int uid) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        CommodityOrderExample commodityOrderExample = new CommodityOrderExample();
        OrderStateflowExample orderStateflowExample = new OrderStateflowExample();
        OrderLogisticsExample orderLogisticsExample = new OrderLogisticsExample();
        commodityOrderExample.createCriteria().andUidEqualTo(uid);
        commodityOrderExample.setOrderByClause("order_id");
        List<CommodityOrder> commodityOrders = commodityOrderMapperE.selectByExample(commodityOrderExample);
        for (CommodityOrder c : commodityOrders) {
            orderLogisticsExample.createCriteria().andOrderIdEqualTo(c.getOrderId());
            orderStateflowExample.createCriteria().andOrderIdEqualTo(c.getOrderId());
            List<OrderStateflow> orderStateflows = orderStateflowMapperE.selectByExample(orderStateflowExample);
        }
        return Result.success(commodityOrders);
    }
}
