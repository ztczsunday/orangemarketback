package com.orangeSoft.market.pojo.extend;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
@Data
public class OrderInfo {
    private Long orderId;
    private String commodityName;
    private String statusName;
    private String shopName;
    private String addressDetails;
    private Date statusDate;
    private String subName;
    private String subIcon;
    private Double price;
}
