package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.UserInfoMapper;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo login(String account, String pwd){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUerTelephoneEqualTo(account).andUserPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if(userInfos.isEmpty()){
            return null;
        }
        return userInfos.get(0);
    }

}
