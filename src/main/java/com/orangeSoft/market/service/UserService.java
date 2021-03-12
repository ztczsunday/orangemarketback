package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.extend.UserInfoMapperE;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//暂时注掉spring security相关
@Service
public class UserService {
    @Autowired
    private UserInfoMapperE userInfoMapperE;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    public UserInfo login(String account, String pwd) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(account).andUserPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapperE.selectByExample(userInfoExample);
        return userInfos.isEmpty() ? null : userInfos.get(0);
    }


    public boolean register(UserInfo userInfo){
        userInfoMapperE.insertSelective(userInfo);
        return true;
    }

}
