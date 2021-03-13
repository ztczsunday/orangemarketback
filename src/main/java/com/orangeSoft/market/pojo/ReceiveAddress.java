package com.orangeSoft.market.pojo;

public class ReceiveAddress {
    private Integer receiveAddressId;

    private Integer uid;

    private String addressDetails;

    private Boolean isDefault;

    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails == null ? null : addressDetails.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", receiveAddressId=").append(receiveAddressId);
        sb.append(", uid=").append(uid);
        sb.append(", addressDetails=").append(addressDetails);
        sb.append(", isDefault=").append(isDefault);
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
        ReceiveAddress other = (ReceiveAddress) that;
        return (this.getReceiveAddressId() == null ? other.getReceiveAddressId() == null : this.getReceiveAddressId().equals(other.getReceiveAddressId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getAddressDetails() == null ? other.getAddressDetails() == null : this.getAddressDetails().equals(other.getAddressDetails()))
                && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReceiveAddressId() == null) ? 0 : getReceiveAddressId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getAddressDetails() == null) ? 0 : getAddressDetails().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        return result;
    }
}