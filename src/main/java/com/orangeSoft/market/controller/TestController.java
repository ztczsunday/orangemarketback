package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.FileManager;
import com.orangeSoft.market.common.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String toLogin() {
        return "/success";
    }

    @RequestMapping(value = "/loginFailure")
    public String toLoginError() {
        return "/failure";
    }

    @RequestMapping(value = "/tiaozhuan")
    public String tiaozhuan() {
        return "/tiaozhuan";
    }
}

@RestController
class RestControllerTest {
    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return Result.success(map);
    }

    @PostMapping(value = "/uploadTest", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        if (file.isEmpty() || StringUtils.isBlank(file.getName())) {
            return Result.fail("文件为空");
        }
        return Result.success(FileManager.saveFile(file));
    }
}