package com.orangeSoft.market.pojo;

public class Shop {
    private Integer sid;

    private Integer uid;

    private String shopName;

    private String shopDescription;

    private String shopAddress;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription == null ? null : shopDescription.trim();
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", uid=").append(uid);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopDescription=").append(shopDescription);
        sb.append(", shopAddress=").append(shopAddress);
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
        Shop other = (Shop) that;
        return (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
                && (this.getShopDescription() == null ? other.getShopDescription() == null : this.getShopDescription().equals(other.getShopDescription()))
                && (this.getShopAddress() == null ? other.getShopAddress() == null : this.getShopAddress().equals(other.getShopAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getShopDescription() == null) ? 0 : getShopDescription().hashCode());
        result = prime * result + ((getShopAddress() == null) ? 0 : getShopAddress().hashCode());
        return result;
    }
}