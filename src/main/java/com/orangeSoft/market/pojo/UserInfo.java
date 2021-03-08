package com.orangeSoft.market.pojo;

public class UserInfo {
    private Integer uid;

    private String userPassword;

    private String userAlipayaccount;

    private String uerTelephone;

    private String userName;

    private String userGender;

    private String userSelfie;

    private String userSignature;

    private String userEmail;

    private String userLicense;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserAlipayaccount() {
        return userAlipayaccount;
    }

    public void setUserAlipayaccount(String userAlipayaccount) {
        this.userAlipayaccount = userAlipayaccount == null ? null : userAlipayaccount.trim();
    }

    public String getUerTelephone() {
        return uerTelephone;
    }

    public void setUerTelephone(String uerTelephone) {
        this.uerTelephone = uerTelephone == null ? null : uerTelephone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getUserSelfie() {
        return userSelfie;
    }

    public void setUserSelfie(String userSelfie) {
        this.userSelfie = userSelfie == null ? null : userSelfie.trim();
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserLicense() {
        return userLicense;
    }

    public void setUserLicense(String userLicense) {
        this.userLicense = userLicense == null ? null : userLicense.trim();
    }
}