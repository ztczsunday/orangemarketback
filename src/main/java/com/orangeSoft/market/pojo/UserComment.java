package com.orangeSoft.market.pojo;

public class UserComment {
    private Long commentId;

    private Integer uid;

    private Boolean praise;

    private String content;

    private Long subComment;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getPraise() {
        return praise;
    }

    public void setPraise(Boolean praise) {
        this.praise = praise;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getSubComment() {
        return subComment;
    }

    public void setSubComment(Long subComment) {
        this.subComment = subComment;
    }
}