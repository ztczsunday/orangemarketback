package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.CommodityOrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    CommodityOrderServiceImpl orderService;

    @ApiOperation(value = "查找用户订单")
    @PostMapping(value = "/order", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findUserOrderByUid(@RequestParam(value = "page", defaultValue = "1") int pages,
                                                   @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        return orderService.findUserOrderByUid(new Page<>(pages, pageSize));
    }

    @ApiOperation(value = "查找订单详情")
    @PostMapping(value = "/orderDetail", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findOrderDetailByOrderId(@RequestParam("orderId") long orderId) {
        return orderService.findOrderDetailByOrderId(orderId);
    }

    @ApiOperation(value = "删除订单记录")
    @PostMapping(value = "/deleteOrder", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteOrderByOrderId(@RequestParam("orderId") long orderId) {
        return orderService.deleteOrderByOrderId(orderId);
    }

    @ApiOperation(value = "增加订单记录")
    @PostMapping(value = "/addOrder", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap addOrder(@RequestParam("subId") int subId,
                                         @RequestParam("countCommodity") int countCommodity,
                                         @RequestParam("receiveAddressId") int receiveAddressId) {
        return orderService.addOrder(subId, receiveAddressId, countCommodity);
    }
}
