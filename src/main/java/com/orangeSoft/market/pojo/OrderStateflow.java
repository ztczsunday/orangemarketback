package com.orangeSoft.market.pojo;

import java.util.Date;

public class OrderStateflow extends OrderStateflowKey {
    private Date statusDate;

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}