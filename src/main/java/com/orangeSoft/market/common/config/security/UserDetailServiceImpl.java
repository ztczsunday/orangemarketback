package com.orangeSoft.market.common.config.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserInfoMapper userInfoMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo loadUserByUsername(String userAccount) throws UsernameNotFoundException {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_telephone", userAccount);
        UserInfo user = userInfoMapper.selectOne(wrapper);
        if (user == null) {
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("账户不存在!");
        }
        System.out.println("用户存在");
        String encodePwd = passwordEncoder.encode(user.getPassword());
        user.setUserPassword(encodePwd);
        return user;
    }
}
