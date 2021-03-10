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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lastBrowserDate=").append(lastBrowserDate);
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
        Footprint other = (Footprint) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getLastBrowserDate() == null ? other.getLastBrowserDate() == null : this.getLastBrowserDate().equals(other.getLastBrowserDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getLastBrowserDate() == null) ? 0 : getLastBrowserDate().hashCode());
        return result;
    }
}