package com.orangeSoft.market.common.pojo;

import java.util.Date;

public class DataDictionary {
    private Long recordId;

    private String tIndex;

    private String itemName;

    private Date recordCreate;

    private String recordDescription;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String gettIndex() {
        return tIndex;
    }

    public void settIndex(String tIndex) {
        this.tIndex = tIndex == null ? null : tIndex.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Date getRecordCreate() {
        return recordCreate;
    }

    public void setRecordCreate(Date recordCreate) {
        this.recordCreate = recordCreate;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription == null ? null : recordDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", tIndex=").append(tIndex);
        sb.append(", itemName=").append(itemName);
        sb.append(", recordCreate=").append(recordCreate);
        sb.append(", recordDescription=").append(recordDescription);
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
        DataDictionary other = (DataDictionary) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
                && (this.gettIndex() == null ? other.gettIndex() == null : this.gettIndex().equals(other.gettIndex()))
                && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
                && (this.getRecordCreate() == null ? other.getRecordCreate() == null : this.getRecordCreate().equals(other.getRecordCreate()))
                && (this.getRecordDescription() == null ? other.getRecordDescription() == null : this.getRecordDescription().equals(other.getRecordDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((gettIndex() == null) ? 0 : gettIndex().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getRecordCreate() == null) ? 0 : getRecordCreate().hashCode());
        result = prime * result + ((getRecordDescription() == null) ? 0 : getRecordDescription().hashCode());
        return result;
    }
}