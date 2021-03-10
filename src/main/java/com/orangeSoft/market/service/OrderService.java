package com.orangeSoft.market.service;


import com.orangeSoft.market.mapper.extend.CommodityOrderMapperE;
import com.orangeSoft.market.mapper.extend.OrderLogisticsMapperE;
import com.orangeSoft.market.mapper.extend.OrderStateflowMapperE;
import com.orangeSoft.market.mapper.extend.OrderStatusMapperE;
import com.orangeSoft.market.pojo.*;
import com.orangeSoft.market.pojo.extend.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderStateflowMapperE orderStateflowMapperE;
    @Autowired
    OrderLogisticsMapperE orderLogisticsMapperE;
    @Autowired
    OrderStatusMapperE orderStatusMapperE;
    @Autowired
    CommodityOrderMapperE commodityOrderMapperE;

//todo
    public List<OrderInfo> findOrder(int userId){
        List<OrderInfo> orderInfos=new ArrayList<>();
        OrderInfo orderInfo=new OrderInfo();
        CommodityOrderExample commodityOrderExample=new CommodityOrderExample();
        OrderStatusExample orderStatusExample=new OrderStatusExample();
        OrderLogisticsExample orderLogisticsExample=new OrderLogisticsExample();
        OrderStateflowExample orderStateflowExample=new OrderStateflowExample();
        commodityOrderExample.createCriteria().andUidEqualTo(userId);
        commodityOrderExample.setOrderByClause("'order_id',DESC");
        List<CommodityOrder> commodityOrders=commodityOrderMapperE.selectByExample(commodityOrderExample);
        for(CommodityOrder i:commodityOrders){
            orderInfo.setOrderId(i.getOrderId());
            orderLogisticsExample.createCriteria().andOrderIdEqualTo(i.getOrderId());
        }

        return orderInfos;
    }
}
