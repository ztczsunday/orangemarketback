package com.orangeSoft.market.service;

import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.mapper.extend.CommodityOrderMapperE;
import com.orangeSoft.market.mapper.extend.OrderLogisticsMapperE;
import com.orangeSoft.market.mapper.extend.OrderStateflowMapperE;
import com.orangeSoft.market.common.pojo.*;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
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

    public Result.JSONResultMap findOrderDetailByOrderId(long orderId) {
        OrderDetailResult orderDetailResult=commodityOrderMapperE.findOrderDetailByOrderId(orderId);
        return Result.success(orderDetailResult);
    }
    public Result.JSONResultMap findUserOrderByUid(){
        UserInfo userInfo= MySessionUtil.getCurrUser();
        List<UserOrderResult> userOrderResults=commodityOrderMapperE.findUserOrderByUserId(userInfo.getUid());
        return Result.success(userOrderResults);
    }
}
