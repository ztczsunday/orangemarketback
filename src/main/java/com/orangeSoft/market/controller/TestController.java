package com.orangeSoft.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        return "/demoForBack/loginDemo";
    }

//    @PostMapping("/loginlogin")
//    public String loginlogin() {
//        return "/success";
//    }
    @RequestMapping("/login")
    public String logia(){
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
