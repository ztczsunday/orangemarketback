package com.orangeSoft.market.pojo;

import java.util.Date;

public class Chat {
    private Long chatId;

    private Long chatContentId;

    private Date chatDate;

    private Integer senderId;

    private String senderType;

    private Integer receiverId;

    private String receiverType;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getChatContentId() {
        return chatContentId;
    }

    public void setChatContentId(Long chatContentId) {
        this.chatContentId = chatContentId;
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType == null ? null : senderType.trim();
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType == null ? null : receiverType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chatId=").append(chatId);
        sb.append(", chatContentId=").append(chatContentId);
        sb.append(", chatDate=").append(chatDate);
        sb.append(", senderId=").append(senderId);
        sb.append(", senderType=").append(senderType);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", receiverType=").append(receiverType);
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
        Chat other = (Chat) that;
        return (this.getChatId() == null ? other.getChatId() == null : this.getChatId().equals(other.getChatId()))
                && (this.getChatContentId() == null ? other.getChatContentId() == null : this.getChatContentId().equals(other.getChatContentId()))
                && (this.getChatDate() == null ? other.getChatDate() == null : this.getChatDate().equals(other.getChatDate()))
                && (this.getSenderId() == null ? other.getSenderId() == null : this.getSenderId().equals(other.getSenderId()))
                && (this.getSenderType() == null ? other.getSenderType() == null : this.getSenderType().equals(other.getSenderType()))
                && (this.getReceiverId() == null ? other.getReceiverId() == null : this.getReceiverId().equals(other.getReceiverId()))
                && (this.getReceiverType() == null ? other.getReceiverType() == null : this.getReceiverType().equals(other.getReceiverType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatId() == null) ? 0 : getChatId().hashCode());
        result = prime * result + ((getChatContentId() == null) ? 0 : getChatContentId().hashCode());
        result = prime * result + ((getChatDate() == null) ? 0 : getChatDate().hashCode());
        result = prime * result + ((getSenderId() == null) ? 0 : getSenderId().hashCode());
        result = prime * result + ((getSenderType() == null) ? 0 : getSenderType().hashCode());
        result = prime * result + ((getReceiverId() == null) ? 0 : getReceiverId().hashCode());
        result = prime * result + ((getReceiverType() == null) ? 0 : getReceiverType().hashCode());
        return result;
    }
}