package com.orangeSoft.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/login")
    public String logia() {
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
}
