package com.orangeSoft.market.controller;

import com.alipay.api.AlipayApiException;
import com.orangeSoft.market.service.impl.AlipayServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

@Controller
public class PayController {


    @Autowired
    AlipayServiceImpl alipayService;

    @ApiOperation(value = "支付宝", notes = "直接使用网址访问：http://localhost:8081/pay?orderId=订单号")
    @RequestMapping("/Alipay")
    @ResponseBody
    public void payController(long orderId, HttpServletResponse response) throws IOException, AlipayApiException {
        alipayService.Alipay(orderId, response);
    }

    //    @ApiOperation(value = "支付宝异步通知")
//    @PostMapping("/AlipayReturn")
//    public String payReturnController(long trade_no, String trade_status){
//        return alipayService.AlipayReturn(trade_no, trade_status);
//    }
    @ApiOperation(value = "支付宝异步通知")
    @RequestMapping(value = "/AlipayReturn",method = RequestMethod.POST)
    public void alipayNotifyUrlInfo(HttpServletRequest request,HttpServletResponse response){
        alipayService.notify(request,response);
    }

}