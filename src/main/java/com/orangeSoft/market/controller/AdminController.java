package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.AdminServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @ApiOperation(value = "查看用户总数")
    @GetMapping(value = "/admin/userAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findUserAmount(){
        return adminService.findUserAmount();
    }

    @ApiOperation(value = "查看各个状态的订单数")
    @GetMapping(value = "/admin/orderAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findOrderStatus(){
        return adminService.findOrderStatus();
    }

    @ApiOperation(value = "查看商品好评率")
    @GetMapping(value = "/admin/praiseAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityPraise(){
        return adminService.findCommodityPraise();
    }

    @ApiOperation(value = "查看每天订单量")
    @GetMapping(value = "/admin/everydayOrderAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findEverydayOrderAmount(@RequestParam("days") int days){
        return adminService.findEverydayOrderAmount(days);
    }
}
