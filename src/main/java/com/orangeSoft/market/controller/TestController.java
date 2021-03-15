package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}