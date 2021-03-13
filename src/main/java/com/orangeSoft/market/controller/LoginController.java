package com.orangeSoft.market.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
