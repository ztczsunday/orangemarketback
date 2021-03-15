package com.orangeSoft.market.controller;

import com.orangeSoft.market.service.IFootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class HistoryController {
    @Autowired
    IFootprintService footprintService;

//    @PostMapping(value = "/histories", produces = "application/json;charset=UTF-8")
//    public Result.JSONResultMap GetHistories
//            (String keyword,
//             @RequestParam(value = "page", defaultValue = "1") int pages,
//             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//        IPage<Footprint> userPage = new Page<>(pages, pageSize);
//        returb Result.success(footprintService.get)
//    }
}
