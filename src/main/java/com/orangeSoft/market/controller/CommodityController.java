package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.CommodityServiceImpl;
import com.orangeSoft.market.service.impl.FavoritesCommodityServiceImpl;
import com.orangeSoft.market.service.impl.UserCommentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommodityController {
    @Autowired
    CommodityServiceImpl commodityService;
    @Autowired
    FavoritesCommodityServiceImpl favoritesCommodityService;
    @Autowired
    UserCommentServiceImpl userCommentService;

    @ApiOperation(value = "根据关键字查询商品查询商品")
    @PostMapping(value = "/findCommodityByKey", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByKey
            (String keyword,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(value = "minValue", defaultValue = "null") Double minValue,
             @RequestParam(value = "maxValue", defaultValue = "null") Double maxValue) {
        return Result.success(commodityService.findCommodityByKey(new Page<>(pages, pageSize), keyword, minValue, maxValue));
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

    @ApiOperation(value = "根据id查找商品详细信息")
    @GetMapping(value = "/commodity", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getCommodityById(Long commodityId) {
        return commodityService.getCommodityById(commodityId);
    }

    @ApiOperation(value = "根据商品ID收藏商品")
    @PostMapping(value = "/commodity/collection", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap collectCommodity(@RequestParam(value = "cid") Long cid) {
        return favoritesCommodityService.addFavoritesCommodity(cid);
    }

    @ApiOperation(value = "根据商品id查找其所有评论", notes = "不包括子评论")
    @GetMapping(value = "/commodity/comment", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getAllCommentsByCid(@RequestParam(value = "cid") Long cid) {
        return userCommentService.getAllCommentsByCid(cid);
    }
}
