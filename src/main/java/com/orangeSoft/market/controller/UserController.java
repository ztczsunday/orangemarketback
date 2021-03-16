package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.service.impl.UserInfoServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserInfoServiceImpl userInfoService;

    @ApiOperation(value = "查找用户信息")
    @GetMapping(value = "/userInfo", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findAddressByUid() {
        return userInfoService.findUserInfoByUid();
    }

    @ApiOperation(value = "用户数据更新", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息", example = "0")
    @ResponseBody
    @PutMapping(value = "/UserInfo", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap userUpdate(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

    @ApiOperation(value = "注册接口", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息")
    @ResponseBody
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap register(@RequestBody UserInfo userInfo) {
        return userInfoService.register(userInfo);
    }
}
