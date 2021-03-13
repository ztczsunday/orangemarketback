package com.orangeSoft.market.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@EqualsAndHashCode
public class OrderDetailResult {
    private int orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String addressDetails;
    private Date statusDate;
}
