package com.orangeSoft.market.controller;

import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public UserInfo login(@RequestParam("account") String account,
                          @RequestParam("password") String password) {
        return userService.login(account,password);
    }
}
