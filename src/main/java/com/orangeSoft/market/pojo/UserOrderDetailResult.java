package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDetailResult {
    private int orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String addressDetails;
    private Date statusDate;
    private String itemName;
    private String subIcon;
}
