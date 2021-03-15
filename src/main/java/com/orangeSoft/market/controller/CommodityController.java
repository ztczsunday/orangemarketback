package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {
    @Autowired
    CommodityServiceImpl commodityService;

    @PostMapping(value = "/findCommodityByKey", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByKey
            (String keyword,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return Result.success(commodityService.findCommodityByKey(new Page<>(pages, pageSize), keyword));
    }

    @PostMapping(value = "/findCommodityByLabel", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByLabel
            (String label,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return Result.success(commodityService.findCommodityByLabel(new Page<>(pages, pageSize), label));
    }
}
