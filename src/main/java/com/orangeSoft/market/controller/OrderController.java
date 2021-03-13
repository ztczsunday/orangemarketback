package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.common.pojo.UserInfo;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation(value = "查找用户订单")
    @PostMapping(value = "/order", produces = "application/json;charset=UTF-8")
    public String findUserOrderByUid() {
        return new Gson().toJson(orderService.findUserOrderByUid());
    }
    @ApiOperation(value = "查找订单详情")
    @PostMapping(value = "/orderDetail", produces = "application/json;charset=UTF-8")
    public String findOrderDetailByOrderId(@RequestParam("orderId") long orderId){
        return new Gson().toJson(orderService.findOrderDetailByOrderId(orderId));
    }
}
