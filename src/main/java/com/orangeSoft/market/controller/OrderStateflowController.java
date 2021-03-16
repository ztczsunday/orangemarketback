package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.OrderStateflowServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class OrderStateflowController {

    @Autowired
    OrderStateflowServiceImpl orderStateflowService;

    @ApiOperation(value = "订单状态更改")
    @PutMapping(value = "/orderStateflow", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updateOrder(@RequestParam(value = "orderId") long orderId,
                                            @RequestParam(value = "recordId") long recordId) {
        return orderStateflowService.updateOrderStateflow(orderId, recordId);
    }
}
