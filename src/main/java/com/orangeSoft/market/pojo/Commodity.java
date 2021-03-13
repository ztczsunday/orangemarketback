package com.orangeSoft.market.pojo;

public class Commodity {
    private Long cid;

    private Integer sid;

    private String commodityName;

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

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public Boolean getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Boolean commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", sid=").append(sid);
        sb.append(", commodityName=").append(commodityName);
        sb.append(", commodityStatus=").append(commodityStatus);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Commodity other = (Commodity) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getCommodityName() == null ? other.getCommodityName() == null : this.getCommodityName().equals(other.getCommodityName()))
            && (this.getCommodityStatus() == null ? other.getCommodityStatus() == null : this.getCommodityStatus().equals(other.getCommodityStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getCommodityName() == null) ? 0 : getCommodityName().hashCode());
        result = prime * result + ((getCommodityStatus() == null) ? 0 : getCommodityStatus().hashCode());
        return result;
    }
}