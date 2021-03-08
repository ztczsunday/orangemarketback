package com.orangeSoft.market.pojo;

public class UserComment {
    private Long commentId;

    private Integer uid;

    private Boolean praise;

    private String conntent;

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

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent == null ? null : conntent.trim();
    }

    public Long getSubComment() {
        return subComment;
    }

    public void setSubComment(Long subComment) {
        this.subComment = subComment;
    }
}