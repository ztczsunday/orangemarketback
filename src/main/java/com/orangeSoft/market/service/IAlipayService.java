package com.orangeSoft.market.service;

import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface IAlipayService {
    /**
     * @param orderId 订单号
     * @param response 支付宝返回接口，不用传入
     */
    void Alipay(long orderId, HttpServletResponse response) throws AlipayApiException, IOException;
}
