package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private Gson gson;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestParam("account") String account,
                          @RequestParam("password") String password) {
        return gson.toJson(userService.login(account, password));
    }

    @GetMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public boolean register(@RequestParam("userTelephone") String userTelephone,
                            @RequestParam("userPassword") String userPassword,
                            @RequestParam("userAlipayAccount") String userAlipayAccount,
                            @RequestParam("userName") String userName,
                            @RequestParam("userGender") String userGender,
                            @RequestParam("userSelfie") String userSelfie,
                            @RequestParam("userSignature") String userSignature,
                            @RequestParam("userEmail") String userEmail,
                            @RequestParam("userLicense") String userLicense) {
        return userService.register(userTelephone,
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
