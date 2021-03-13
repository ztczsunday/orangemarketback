package com.orangeSoft.market.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Data
@Component
@EqualsAndHashCode
public class UserOrderResult {
    private int orderId;
    private String commodityName;
    private String subName;
    private String shopName;
    private int countCommodity;
    private double price;
}
