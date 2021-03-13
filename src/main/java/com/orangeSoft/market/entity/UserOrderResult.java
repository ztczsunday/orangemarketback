package com.orangeSoft.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserOrderResult {
    private int orderId;
    private String commodityName;
    private String subName;
    private String shopName;
    private int countCommodity;
    private double price;
}
