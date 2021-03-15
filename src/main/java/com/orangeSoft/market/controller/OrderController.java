package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.service.impl.CommodityOrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://localhost:8080")
public class OrderController {
    @Autowired
    CommodityOrderServiceImpl orderService;

    @ApiOperation(value = "查找用户订单")
    @PostMapping(value = "/order", produces = "application/json;charset=UTF-8")
    public String findUserOrderByUid() {
        return new Gson().toJson(orderService.findUserOrderByUid());
    }

    @ApiOperation(value = "查找订单详情")
    @PostMapping(value = "/orderDetail", produces = "application/json;charset=UTF-8")
    public String findOrderDetailByOrderId(@RequestParam("orderId") long orderId) {
        return new Gson().toJson(orderService.findOrderDetailByOrderId(orderId));
    }
}
