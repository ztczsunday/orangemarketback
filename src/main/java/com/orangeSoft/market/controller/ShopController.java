package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.service.impl.CommodityServiceImpl;
import com.orangeSoft.market.service.impl.ShopServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
public class ShopController {
    @Autowired
    ShopServiceImpl shopService;
    @Autowired
    CommodityServiceImpl commodityService;

    @ApiOperation(value = "创建商店")
    @PostMapping(value = "/shop", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "shop", dataType = "Shop", value = "新商店信息", example = "0")
    public Result.JSONResultMap registerShop(@RequestBody Shop newShop) {
        return shopService.registerShop(newShop);
    }

    @ApiOperation(value = "创建商店")
    @PutMapping(value = "/shop", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "shop", dataType = "Shop", value = "新商店信息", example = "0")
    public Result.JSONResultMap updateShop(@RequestBody Shop newShop) {
        return shopService.updateShop(newShop);
    }

    @ApiOperation(value = "商店首页", notes = "商家查看自己店铺的商品")
    @GetMapping(value = "/shop", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap shopCommodity(@RequestParam(value = "page", defaultValue = "1") int pages,
                                              @RequestParam(value = "pageSize", defaultValue = "40") int pageSize) {
        return shopService.shopCommodity(new Page<>(pages, pageSize));
    }

    @ApiOperation(value = "查看某商店详情", notes = "买家进入店铺查看其详细信息，以及是否被收藏")
    @GetMapping(value = "/shop/visit", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getShopCommodities(@RequestParam(value = "sid") Integer sid) {
        return commodityService.getShopDetailsBySid(sid);
    }

    @ApiOperation(value = "查看某商店所有上架商品")
    @GetMapping(value = "/shop/visit/open", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getShopCommoditiesOpen(@RequestParam(value = "sid") Integer sid,
                                                       @RequestParam(value = "page") int page,
                                                       @RequestParam(value = "pageSize") int pageSize) {
        return commodityService.getShopCommoditiesOpen(new Page<>(page, pageSize), sid);
    }

    @ApiOperation(value = "查看某商店所有下架商品")
    @GetMapping(value = "/shop/visit/close", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getShopCommoditiesClose(@RequestParam(value = "sid") Integer sid,
                                                        @RequestParam(value = "page") int page,
                                                        @RequestParam(value = "pageSize") int pageSize) {
        return commodityService.getShopCommoditiesClose(new Page<>(page, pageSize), sid);
    }

    @ApiOperation(value = "修改简介")
    @PutMapping(value = "/shop/update", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updateShopDescription(@RequestParam(value = "sid") Integer sid,
                                                      @RequestParam(value = "shopDescription") String shopDescription) {
        return shopService.updateShopDescription(sid, shopDescription);
    }
}
