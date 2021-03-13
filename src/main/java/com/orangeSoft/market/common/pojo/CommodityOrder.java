package com.orangeSoft.market.common.pojo;

public class CommodityOrder {
    private Long orderId;

    private Long commentId;

    private Integer sid;

    private Integer uid;

    private Integer receiveAddressId;

    private Integer subId;

    private Integer countCommodity;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

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

    public Integer getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Integer receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getCountCommodity() {
        return countCommodity;
    }

    public void setCountCommodity(Integer countCommodity) {
        this.countCommodity = countCommodity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", commentId=").append(commentId);
        sb.append(", sid=").append(sid);
        sb.append(", uid=").append(uid);
        sb.append(", receiveAddressId=").append(receiveAddressId);
        sb.append(", subId=").append(subId);
        sb.append(", countCommodity=").append(countCommodity);
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
        CommodityOrder other = (CommodityOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
                && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
                && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getReceiveAddressId() == null ? other.getReceiveAddressId() == null : this.getReceiveAddressId().equals(other.getReceiveAddressId()))
                && (this.getSubId() == null ? other.getSubId() == null : this.getSubId().equals(other.getSubId()))
                && (this.getCountCommodity() == null ? other.getCountCommodity() == null : this.getCountCommodity().equals(other.getCountCommodity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getReceiveAddressId() == null) ? 0 : getReceiveAddressId().hashCode());
        result = prime * result + ((getSubId() == null) ? 0 : getSubId().hashCode());
        result = prime * result + ((getCountCommodity() == null) ? 0 : getCountCommodity().hashCode());
        return result;
    }
}