package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.FileManager;
import com.orangeSoft.market.common.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @ApiOperation(value = "下载文件", notes = "fileName对应数据库存储的")
    @GetMapping(value = "/download", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        if (!new File(FileManager.MAIN_FILE_PATH + fileName).exists()) {
            return Result.fail(null, "喔唷,找不到文件,可能是文件不存在");
        }
        FileManager.getFile(fileName, response);
        return Result.success();
    }

    @ApiOperation(value = "上传文件", notes = "文件不能为空，文件名不能为空和包含'/'")
    @PostMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        if (file.isEmpty() || StringUtils.isBlank(file.getName())) {
            return Result.fail("文件为空");
        }
        return Result.success(FileManager.saveFile(file));
    }
}
