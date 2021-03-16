package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.FavoritesCommodityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavoritesCommodityController {
    @Autowired
    FavoritesCommodityServiceImpl favoritesCommodityService;

    @ApiOperation(value = "查看收藏的商品")
    @GetMapping(value = "/favoritesCommodity", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findFavoritesCommodityByUid(@RequestParam(value = "page", defaultValue = "1") int pages,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return favoritesCommodityService.getMyFavoriteCommodity(new Page<>(pages, pageSize));
    }

    @ApiOperation(value = "移除收藏的商品")
    @DeleteMapping(value = "/favoritesCommodity", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteFavoritesCommodity(@RequestParam("cid") long cid) {
        return favoritesCommodityService.deleteFavoritesCommodity(cid);
    }

    @ApiOperation(value = "商品收藏")
    @PostMapping(value = "/favoritesCommodity", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap addFavoritesCommodity(@RequestParam("cid") long cid) {
        return favoritesCommodityService.addFavoritesCommodity(cid);
    }

}
