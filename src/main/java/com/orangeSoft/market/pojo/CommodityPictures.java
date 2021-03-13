package com.orangeSoft.market.pojo;

public class CommodityPictures {
    private Long pid;

    private String pictureUrl;

    private Long cid;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", cid=").append(cid);
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
        CommodityPictures other = (CommodityPictures) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
                && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        return result;
    }
}