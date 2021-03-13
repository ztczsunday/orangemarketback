package com.orangeSoft.market.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

import java.sql.Date;

@Component
@Data
@Component
public class OrderDetailResult {
    private int orderId;
    private String shopName;
    private String commodityName;
    private String subName;
    private double price;
    private int countCommodity;
    private String addressDetails;
    private Date statusTime;
}
