package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.FootprintServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {
    @Autowired
    FootprintServiceImpl footprintService;

    @ApiOperation(value = "查询历史记录")
    @GetMapping(value = "/histories", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap GetHistories(
            @RequestParam(value = "page", defaultValue = "1") Integer pages,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(footprintService.findFootPrintByUid(new Page<>(pages, pageSize)));
    }

    @ApiOperation(value = "增加历史记录")
    @PostMapping(value = "/histories", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap AddHistories(@RequestParam(value = "cid") Long cid) {
        if (footprintService.addFootPrint(cid)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
