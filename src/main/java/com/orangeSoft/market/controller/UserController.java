package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.pojo.UserInfo;
import com.orangeSoft.market.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:8080")
public class UserController {
    @Autowired
    UserService userService;


    @ApiOperation(value = "用户数据更新", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息")
    @ResponseBody
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public boolean userUpdate(@RequestBody UserInfo userInfo) {
        return userService.update(userInfo);
    }

    @ApiOperation(value = "注册接口", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息")
    @ResponseBody
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public boolean register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }
}
