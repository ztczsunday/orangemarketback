package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrderResult {
    private int orderId;
    private String userName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String addressDetails;
    private String itemName;
    private String subIcon;
}
