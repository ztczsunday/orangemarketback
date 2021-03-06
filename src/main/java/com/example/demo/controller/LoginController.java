package com.example.demo.controller;

import com.example.demo.pojo.LoginResult;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MakiYO
 * @create 2021/3/6
 */
//todo
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public LoginResult login(@RequestParam("uTel") String uTel,
                             @RequestParam("uPassword") String uPassword){
        return loginService.login(uTel,uPassword);
    }
}
