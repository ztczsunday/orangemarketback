package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.FavoritesShopServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FavoritesShopController {
    @Autowired
    FavoritesShopServiceImpl favoritesShopService;

    @ApiOperation(value = "查看收藏的商店")
    @GetMapping(value = "/favoritesShop", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findFavoritesCommodityByUid(@RequestParam(value = "page", defaultValue = "1") int pages,
                                                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return favoritesShopService.getMyFavoriteShop(new Page<>(pages, pageSize));
    }

    @ApiOperation(value = "移除收藏的商店")
    @DeleteMapping(value = "/favoritesShop", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteFavoritesCommodity(@RequestParam("sid") int sid) {
        return favoritesShopService.deleteFavoritesShop(sid);
    }

    @ApiOperation(value = "商店收藏")
    @PostMapping(value = "/favoritesShop", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap addFavoritesCommodity(@RequestParam("sid") int sid) {
        return favoritesShopService.addFavoritesShop(sid);
    }

}
