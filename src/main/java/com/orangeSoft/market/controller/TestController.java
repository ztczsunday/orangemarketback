package com.orangeSoft.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        return "/demoForBack/loginDemo";
    }
}
