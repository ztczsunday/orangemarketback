package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private Gson gson;

    @ApiOperation(value = "登录方法",notes = "114514")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "手机号",required = true,paramType = "form"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,paramType = "form")
    })
//    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
//    public String login(@RequestParam("account") String account,
//                          @RequestParam("password") String password) {
//        return gson.toJson(userService.login(account, password));
//    }

    @ApiOperation(value = "注册方法",notes = "114514")
    @ApiImplicitParam(name = "userInfo",dataType = "UserInfo",value = "用户信息")
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }
}
