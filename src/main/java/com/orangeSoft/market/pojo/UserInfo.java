package com.orangeSoft.market.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserInfo implements UserDetails {
    private Integer uid;

    private String userTelephone;

    private String userPassword;

    private String userName;

    private String userGender;

    private String userSelfie;

    private String userSignature;

    private String userAlipayAccount;

    private String userEmail;

    private String userLicense;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
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

    public String getUserAlipayAccount() {
        return userAlipayAccount;
    }

    public void setUserAlipayAccount(String userAlipayAccount) {
        this.userAlipayAccount = userAlipayAccount == null ? null : userAlipayAccount.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", userTelephone=").append(userTelephone);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userName=").append(userName);
        sb.append(", userGender=").append(userGender);
        sb.append(", userSelfie=").append(userSelfie);
        sb.append(", userSignature=").append(userSignature);
        sb.append(", userAlipayAccount=").append(userAlipayAccount);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userLicense=").append(userLicense);
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
        UserInfo other = (UserInfo) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getUserTelephone() == null ? other.getUserTelephone() == null : this.getUserTelephone().equals(other.getUserTelephone()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserGender() == null ? other.getUserGender() == null : this.getUserGender().equals(other.getUserGender()))
            && (this.getUserSelfie() == null ? other.getUserSelfie() == null : this.getUserSelfie().equals(other.getUserSelfie()))
            && (this.getUserSignature() == null ? other.getUserSignature() == null : this.getUserSignature().equals(other.getUserSignature()))
            && (this.getUserAlipayAccount() == null ? other.getUserAlipayAccount() == null : this.getUserAlipayAccount().equals(other.getUserAlipayAccount()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getUserLicense() == null ? other.getUserLicense() == null : this.getUserLicense().equals(other.getUserLicense()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUserTelephone() == null) ? 0 : getUserTelephone().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserGender() == null) ? 0 : getUserGender().hashCode());
        result = prime * result + ((getUserSelfie() == null) ? 0 : getUserSelfie().hashCode());
        result = prime * result + ((getUserSignature() == null) ? 0 : getUserSignature().hashCode());
        result = prime * result + ((getUserAlipayAccount() == null) ? 0 : getUserAlipayAccount().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getUserLicense() == null) ? 0 : getUserLicense().hashCode());
        return result;
    }

    /**
     * @return 当前用户角色信息(集合)，均为null
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * @return 当前用户是否未过期, 默认为false,改为true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return 当前用户是否未锁定，默认返回false, 改为true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return 当前用户密码是否未过期, 默认返回false, 改为true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return 当前账户是否可用，改为true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}