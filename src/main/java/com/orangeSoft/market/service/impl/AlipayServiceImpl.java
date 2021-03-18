package com.orangeSoft.market.service.impl;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.orangeSoft.market.common.config.AlipayConfig;
import com.orangeSoft.market.mapper.CommodityOrderMapper;
import com.orangeSoft.market.pojo.UserOrderDetailResult;
import com.orangeSoft.market.service.IAlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Service
public class AlipayServiceImpl implements IAlipayService {
    @Autowired
    CommodityOrderMapper commodityOrderMapper;

    @Override
    public void Alipay(long orderId, HttpServletResponse response) throws AlipayApiException, IOException {
        // 获取初始化的AliPayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
        // 设置请求参数
        // PC端为AlipayTradePagePayRequest
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = String.valueOf(orderId);
        UserOrderDetailResult userOrderDetailResult = commodityOrderMapper.findOrderDetailByOrderId(orderId);

        //付款金额，必填
        String total_amount = String.valueOf(userOrderDetailResult.getCountCommodity() * userOrderDetailResult.getPrice());
        //订单名称，必填
        String subject = userOrderDetailResult.getCommodityName();
        //商品描述，可空
        String body = userOrderDetailResult.getSubName();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
//        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//        		+ "\"total_amount\":\""+ total_amount +"\","
//        		+ "\"subject\":\""+ subject +"\","
//        		+ "\"body\":\""+ body +"\","
//        		+ "\"timeout_express\":\"10m\","
//        		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//        请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
//
//        请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
//
//        输出
        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();
//    }
//
//    @RequestMapping("/")
//    public String toIndex(){
//        return "index";
//    }

    }
}
