package com.orangeSoft.market.pojo;

import java.util.Date;

public class Chat {
    private Long chatId;

    private String chatContent;

    private Date chatDate;

    private Boolean chatStatus;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    public Boolean getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(Boolean chatStatus) {
        this.chatStatus = chatStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chatId=").append(chatId);
        sb.append(", chatContent=").append(chatContent);
        sb.append(", chatDate=").append(chatDate);
        sb.append(", chatStatus=").append(chatStatus);
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
            && (this.getChatContent() == null ? other.getChatContent() == null : this.getChatContent().equals(other.getChatContent()))
            && (this.getChatDate() == null ? other.getChatDate() == null : this.getChatDate().equals(other.getChatDate()))
            && (this.getChatStatus() == null ? other.getChatStatus() == null : this.getChatStatus().equals(other.getChatStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatId() == null) ? 0 : getChatId().hashCode());
        result = prime * result + ((getChatContent() == null) ? 0 : getChatContent().hashCode());
        result = prime * result + ((getChatDate() == null) ? 0 : getChatDate().hashCode());
        result = prime * result + ((getChatStatus() == null) ? 0 : getChatStatus().hashCode());
        return result;
    }
}