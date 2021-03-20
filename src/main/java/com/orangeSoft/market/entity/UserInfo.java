package com.orangeSoft.market.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 所有用户
 * </p>
 *
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserInfo implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
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
