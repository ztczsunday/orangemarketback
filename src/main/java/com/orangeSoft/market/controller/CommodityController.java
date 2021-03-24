package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.pojo.CommodityUpdateData;
import com.orangeSoft.market.pojo.NewCommodityData;
import com.orangeSoft.market.service.impl.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CommodityController {
    @Autowired
    CommodityServiceImpl commodityService;
    @Autowired
    FavoritesCommodityServiceImpl favoritesCommodityService;
    @Autowired
    UserCommentServiceImpl userCommentService;
    @Autowired
    SubCommentsServiceImpl subCommentsService;
    @Autowired
    DataDictionaryServiceImpl dictionaryService;
    @Autowired
    SubCommodityServiceImpl subCommodityService;

    @ApiOperation(value = "根据关键字查询商品查询商品")
    @PostMapping(value = "/findCommodityByKey", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByKey
            (@RequestParam(value = "keyword") String keyword,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(value = "minValue", required = false) Double minValue,
             @RequestParam(value = "maxValue", required = false) Double maxValue,
             @RequestParam(value = "orderColumn", required = false) String orderColumn) {
        return Result.success(commodityService.findCommodityByKey(new Page<>(pages, pageSize), keyword, minValue, maxValue, orderColumn));
    }

    @ApiOperation(value = "根据标签查询商品")
    @PostMapping(value = "/findCommodityByLabel", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findCommodityByLabel
            (@RequestParam(value = "label") String label,
             @RequestParam(value = "page", defaultValue = "1") int pages,
             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
             @RequestParam(value = "minValue", required = false) Double minValue,
             @RequestParam(value = "maxValue", required = false) Double maxValue,
             @RequestParam(value = "orderColumn", required = false) String orderColumn) {
        return Result.success(commodityService.findCommodityByLabel(new Page<>(pages, pageSize), label, minValue, maxValue, orderColumn));
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

    @ApiOperation(value = "根据商品id分页查找其所有评论", notes = "不包括子评论")
    @GetMapping(value = "/commodity/comment", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getAllCommentsByCid(
            @RequestParam(value = "cid") Long cid,
            @RequestParam(value = "page", defaultValue = "1") int pages,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return userCommentService.getAllCommentsByCid(new Page<>(pages, pageSize), cid);
    }

    @ApiOperation(value = "查找评论下所有子评论")
    @GetMapping(value = "/commodity/comment/subComments", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getSubComments(@RequestParam(value = "commentId") Long commentId) {
        return subCommentsService.getSubComments(commentId);
    }

    @ApiOperation(value = "首页推荐商品", notes = "根据用户历史记录产生，具有随机性。无历史记录则固定，无随机性")
    @GetMapping(value = "/recommends", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getRecommends() {
        return commodityService.recommendCommodities();
    }

    @ApiOperation(value = "卖家新增商品")
    @PostMapping(value = "/commodity", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "NewCommodityData", dataType = "NewCommodityData", value = "新商品信息")
    public Result.JSONResultMap newCommodity(@RequestBody NewCommodityData newCommodityData) {
        return commodityService.newCommodity(newCommodityData);
    }

    @ApiOperation(value = "查看待编辑商品信息")
    @GetMapping(value = "/commodityUpdate", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getUpdatedCommodity(@RequestParam("cid") long cid) {
        return commodityService.getUpdatedCommodity(cid);
    }

    @ApiOperation(value = "更新商品信息")
    @PutMapping(value = "/commodityUpdate", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap UpdatedCommodity(@RequestBody CommodityUpdateData commodityUpdateData) {
        return commodityService.updatedCommodity(commodityUpdateData);
    }

    @ApiOperation(value = "查找所有标签")
    @GetMapping(value = "/commodity/labels", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getAllLabels() {
        return dictionaryService.getAllLabels();
    }

    @ApiOperation(value = "新增标签")
    @PostMapping(value = "/commodity/newLabel", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap addNewLabel(@RequestParam(value = "labelName") String labelName) {
        return dictionaryService.addNewLabel(labelName);
    }

    @ApiOperation(value = "修改库存")
    @PutMapping(value = "/commodity/updateStock", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updateStock(@RequestParam(value = "stock") int stock,
                                            @RequestParam(value = "subId") int subId) {
        return subCommodityService.updateStock(subId, stock);
    }

    @ApiOperation(value = "修改库存")
    @PutMapping(value = "/commodity/updateStatus", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updatedCommodityStatus(@RequestParam(value = "cid") long cid,
                                                       @RequestParam(value = "commodityStatus") boolean commodityStatus) {
        return commodityService.updatedCommodityStatus(cid, commodityStatus);
    }
}
