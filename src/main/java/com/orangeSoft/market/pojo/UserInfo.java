package com.orangeSoft.market.pojo;


import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class UserInfo {
    private Integer uid;

    private String userPassword;

    private String userAlipayAccount;

    private String userTelephone;

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

    public String getUserAlipayAccount() {
        return userAlipayAccount;
    }

    public void setUserAlipayAccount(String userAlipayAccount) {
        this.userAlipayAccount = userAlipayAccount == null ? null : userAlipayAccount.trim();
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
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