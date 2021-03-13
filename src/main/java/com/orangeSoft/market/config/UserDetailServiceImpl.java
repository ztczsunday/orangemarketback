package com.orangeSoft.market.config;

import com.orangeSoft.market.mapper.extend.UserInfoMapperE;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义spring security用户实体，从数据库中获取用户信息
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoMapperE userInfoMapperE;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(userAccount);
        if (userInfoMapperE.selectByExample(userInfoExample).isEmpty()) {
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("账户不存在!");
        }
        System.out.println("用户存在");
        UserInfo user = userInfoMapperE.selectByExample(userInfoExample).get(0);
        String encodePwd = passwordEncoder.encode(user.getPassword());
        user.setUserPassword(encodePwd);
        System.out.println(user.toString());
        return user;
    }

}
