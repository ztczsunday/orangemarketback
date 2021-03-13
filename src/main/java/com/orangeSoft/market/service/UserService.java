package com.orangeSoft.market.service;

import com.orangeSoft.market.common.pojo.UserInfo;
import com.orangeSoft.market.common.pojo.UserInfoExample;
import com.orangeSoft.market.mapper.extend.UserInfoMapperE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//暂时注掉spring security相关
@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoMapperE userInfoMapperE;

    public UserInfo login(String account, String pwd) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(account).andUserPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapperE.selectByExample(userInfoExample);
        return userInfos.isEmpty() ? null : userInfos.get(0);
    }


    public boolean register(UserInfo userInfo) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(userInfo.getUserTelephone());
        if (userInfoMapperE.countByExample(userInfoExample) != 0) {
            return false;
        }
        return userInfoMapperE.insertSelective(userInfo) == 1;
    }

    public boolean update(UserInfo userInfo) {
        if (userInfoMapperE.updateByPrimaryKeySelective(userInfo) != 1) {
            return false;
        }
        return true;
    }
}
