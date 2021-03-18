package com.orangeSoft.market.controller;

import com.alipay.api.AlipayApiException;
import com.orangeSoft.market.service.impl.AlipayServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PayController {


    @Autowired
    AlipayServiceImpl alipayService;

    @ApiOperation(value = "支付宝",notes = "直接使用网址访问：http://localhost:8081/pay?orderId=订单号")
    @RequestMapping("/Alipay")
    @ResponseBody
    public void payController(long orderId, HttpServletResponse response) throws IOException, AlipayApiException {
        alipayService.Alipay(orderId,response);
    }
}