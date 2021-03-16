package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.ShopServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    ShopServiceImpl shopService;

    @ApiOperation(value = "查找店铺信息")
    @GetMapping(value = "/shop/info", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getShopInfo(@RequestParam(value = "sid") Integer sid) {
        return Result.success(shopService.getShopById(sid));
    }

}
