package com.orangeSoft.market.controller;

import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public boolean register(@RequestParam("uerTelephone") String uerTelephone,
                            @RequestParam("userPassword") String userPassword,
                            @RequestParam("userAlipayAccount") String userAlipayAccount,
                            @RequestParam("userName") String userName,
                            @RequestParam("userGender") String userGender,
                            @RequestParam("userSelfie") String userSelfie,
                            @RequestParam("userSignature") String userSignature,
                            @RequestParam("userEmail") String userEmail,
                            @RequestParam("userLicense") String userLicense){
        return userService.register(uerTelephone,
                userPassword,
                userAlipayAccount,
                userName,
                userGender,
                userSelfie,
                userSignature,
                userEmail,
                userLicense);
    }
}
