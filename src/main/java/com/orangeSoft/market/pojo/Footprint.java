package com.orangeSoft.market.pojo;

import java.util.Date;

public class Footprint extends FootprintKey {
    private Date lastBrowserDate;

    public Date getLastBrowserDate() {
        return lastBrowserDate;
    }

    public void setLastBrowserDate(Date lastBrowserDate) {
        this.lastBrowserDate = lastBrowserDate;
    }
}