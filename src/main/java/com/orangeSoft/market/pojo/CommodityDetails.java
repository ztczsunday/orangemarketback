package com.orangeSoft.market.pojo;

public class CommodityDetails {
    private Long detailsId;

    private Long cid;

    private String detailsUrl;

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getDetailsUrl() {
        return detailsUrl;
    }

    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl == null ? null : detailsUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailsId=").append(detailsId);
        sb.append(", cid=").append(cid);
        sb.append(", detailsUrl=").append(detailsUrl);
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
        CommodityDetails other = (CommodityDetails) that;
        return (this.getDetailsId() == null ? other.getDetailsId() == null : this.getDetailsId().equals(other.getDetailsId()))
                && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
                && (this.getDetailsUrl() == null ? other.getDetailsUrl() == null : this.getDetailsUrl().equals(other.getDetailsUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailsId() == null) ? 0 : getDetailsId().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getDetailsUrl() == null) ? 0 : getDetailsUrl().hashCode());
        return result;
    }
}