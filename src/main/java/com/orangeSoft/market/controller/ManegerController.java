package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.ManagerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManegerController {

    @Autowired
    ManagerServiceImpl managerService;

    @ApiOperation(value = "查看用户总数")
    @GetMapping(value = "/Manager/userAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findUserAmount() {
        return managerService.findUserAmount();
    }

    @ApiOperation(value = "查看各个状态的订单数")
    @GetMapping(value = "/Manager/orderAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findOrderStatus() {
        return managerService.findOrderStatus();
    }

    @ApiOperation(value = "查看商品好评率")
    @GetMapping(value = "/Manager/praiseAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityPraise() {
        return managerService.findCommodityPraise();
    }

    @ApiOperation(value = "查看每天订单量")
    @GetMapping(value = "/Manager/everydayOrderAmount", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findEverydayOrderAmount(@RequestParam("days") int days,
                                                        @RequestParam("recordId") int recordId) {
        return managerService.findEverydayOrderAmount(days, recordId);
    }

    @ApiOperation(value = "管理员登录")
    @GetMapping(value = "/Manager/login", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap ManagerLogin(@RequestParam("ManagerPassword") String managerPassword,
                                             @RequestParam("ManagerAccount") String managerAccount) {
        return managerService.managerLogin(managerAccount, managerPassword);
    }
}
