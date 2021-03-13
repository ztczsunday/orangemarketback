package com.orangeSoft.market.service;


import com.orangeSoft.market.mapper.extend.CommodityMapperE;
import com.orangeSoft.market.mapper.extend.CommodityOrderMapperE;
import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserOrderResult;
import com.orangeSoft.market.utils.MySessionUtil;
import com.orangeSoft.market.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    CommodityOrderMapperE commodityOrderMapperE;

    public Result.JSONResultMap findOrderDetailByOrderId(int orderId) {
        OrderDetailResult orderDetailResults = commodityOrderMapperE.findOrderDetailByOrderId(orderId);
        return Result.success(orderDetailResults);
    }

    public Result.JSONResultMap findUserOrderByUid() {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        List<UserOrderResult> userOrderResults = commodityOrderMapperE.findUserOrderByUserId(userInfo.getUid());
        return Result.success((userOrderResults));
    }
}
