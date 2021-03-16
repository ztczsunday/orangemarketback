package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderResult {
    private int orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String itemName;
    private String subIcon;
}
