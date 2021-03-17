package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.FileManager;
import com.orangeSoft.market.common.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FileController {

    @ApiOperation(value = "下载商品", notes = "fileName对应数据库存储的")
    @GetMapping(value = "/download")
    public Result.JSONResultMap getFile(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        return FileManager.getFile(fileName, response);
    }
}
