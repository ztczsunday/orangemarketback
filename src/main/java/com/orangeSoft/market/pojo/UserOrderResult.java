package com.orangeSoft.market.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserOrderResult {
    private long orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private double price;
}
