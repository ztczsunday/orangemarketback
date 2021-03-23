package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserOrderResult {
    private long orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String itemName;
    private String subIcon;
}
