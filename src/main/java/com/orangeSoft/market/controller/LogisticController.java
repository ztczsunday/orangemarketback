package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Logistics;
import com.orangeSoft.market.service.impl.LogisticsServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogisticController {
    @Autowired
    LogisticsServiceImpl logisticsService;

    @ApiOperation(value = "查看所有物流公司")
    @GetMapping(value = "/logistic", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findAllLogistics() {
        return logisticsService.findAllLogistics();
    }

    @ApiOperation(value = "更新物流公司信息")
    @ApiImplicitParam(name = "logistics", dataType = "Logistics", value = "新物流公司信息")
    @PutMapping(value = "/logistic", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updateLogistics(@RequestBody Logistics logistics) {
        return logisticsService.updateLogistics(logistics);
    }

    @ApiOperation(value = "添加物流公司")
    @ApiImplicitParam(name = "logistics", dataType = "Logistics", value = "新收货地址")
    @PostMapping(value = "/logistic", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap insertLogistics(@RequestBody Logistics logistics) {
        return logisticsService.insertLogistics(logistics);
    }

    @ApiOperation(value = "删除物流公司")
    @DeleteMapping(value = "/logistic", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteLogistics(@RequestParam Integer logisticsId) {
        return logisticsService.deleteLogistics(logisticsId);
    }
}
