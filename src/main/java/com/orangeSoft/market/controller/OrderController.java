package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @ApiOperation(value = "查找订单")
    @PostMapping(value = "/order", produces = "application/json;charset=UTF-8")
    public String findOrderByUid(@RequestParam("uid") Integer uid){
        return new Gson().toJson(orderService.findOrderByUid(uid));
    }
}
