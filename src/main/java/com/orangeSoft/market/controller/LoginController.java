package com.orangeSoft.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
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

    @RequestMapping(value = "/tiaozhuan")
    public String tiaozhuan() {
        return "/tiaozhuan";
    }

    @RequestMapping("/")
    public String goFront() {
        return "redirect:/index.html#/login";
    }
}
