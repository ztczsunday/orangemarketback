package com.orangeSoft.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("http://localhost:8080")
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
