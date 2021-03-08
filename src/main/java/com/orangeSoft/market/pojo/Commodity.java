package com.orangeSoft.market.pojo;

public class Commodity {
    private Long cid;

    private Integer sid;

    private String commodityAme;

    private String commodityDescription;

    private Boolean commodityStatus;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCommodityAme() {
        return commodityAme;
    }

    public void setCommodityAme(String commodityAme) {
        this.commodityAme = commodityAme == null ? null : commodityAme.trim();
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription == null ? null : commodityDescription.trim();
    }

    public Boolean getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Boolean commodityStatus) {
        this.commodityStatus = commodityStatus;
    }
}