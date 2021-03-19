package com.orangeSoft.market.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.service.impl.FootprintServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoryController {
    @Autowired
    FootprintServiceImpl footprintService;

    @ApiOperation(value = "查询历史记录")
    @GetMapping(value = "/histories", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getHistories(
            @RequestParam(value = "page", defaultValue = "1") int pages,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return Result.success(footprintService.findFootPrintByUid(new Page<>(pages, pageSize)));
    }

    @ApiOperation(value = "删除历史记录")
    @DeleteMapping(value = "/histories", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteFootPrint(@RequestParam("cid") long cid) {
        return footprintService.deleteFootPrint(cid);
    }

    @ApiOperation(value = "添加历史记录")
    @PostMapping(value = "/histories", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap addFootPrint(@RequestParam("cid") long cid) {
        return footprintService.addFootPrint(cid);
    }
}
