package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.extend.UserInfoMapperE;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//暂时注掉spring security相关
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoMapperE userInfoMapperE;

    public boolean register(UserInfo userInfo) {
//        passwordEncoder.encode(userInfo.getUserPassword());
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(userInfo.getUserTelephone());
        if (userInfoMapperE.countByExample(userInfoExample) != 0) {
            return false;
        }
        return userInfoMapperE.insertSelective(userInfo) == 1;
    }

    public boolean update(UserInfo userInfo) {
        return userInfoMapperE.insertSelective(userInfo) != 0;
    }
}
