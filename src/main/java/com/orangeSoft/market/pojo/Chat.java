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
}