package com.orangeSoft.market.pojo;

public class ChatDetails {
    private Long chatContentId;

    private String chatContent;

    public Long getChatContentId() {
        return chatContentId;
    }

    public void setChatContentId(Long chatContentId) {
        this.chatContentId = chatContentId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chatContentId=").append(chatContentId);
        sb.append(", chatContent=").append(chatContent);
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
        ChatDetails other = (ChatDetails) that;
        return (this.getChatContentId() == null ? other.getChatContentId() == null : this.getChatContentId().equals(other.getChatContentId()))
                && (this.getChatContent() == null ? other.getChatContent() == null : this.getChatContent().equals(other.getChatContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatContentId() == null) ? 0 : getChatContentId().hashCode());
        result = prime * result + ((getChatContent() == null) ? 0 : getChatContent().hashCode());
        return result;
    }
}