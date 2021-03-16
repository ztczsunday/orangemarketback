package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.CommodityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class CommodityController {
    @Autowired
    CommodityServiceImpl commodityService;

    @ApiOperation(value = "根据关键字查询商品查询商品")
    @PostMapping(value = "/findCommodityByKey", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByKey
            (String keyword,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return Result.success(commodityService.findCommodityByKey(new Page<>(pages, pageSize), keyword));
    }

    @ApiOperation(value = "根据标签查询商品")
    @PostMapping(value = "/findCommodityByLabel", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByLabel
            (String label,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(value = "minValue", defaultValue = "null") Double minValue,
             @RequestParam(value = "maxValue", defaultValue = "null") Double maxValue) {
        return Result.success(commodityService.findCommodityByLabel(new Page<>(pages, pageSize), label, minValue, maxValue));
    }
}
