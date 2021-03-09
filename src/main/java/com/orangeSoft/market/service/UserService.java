package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.UserInfoMapper;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserInfo login(String account, String pwd){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(account).andUserPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if(userInfos.isEmpty()){
            return null;
        }
        return userInfos.get(0);
    }

    public boolean register(String userTelephone,
                            String userPassword,
                            String userAlipayAccount,
                            String userName,
                            String userGender,
                            String userSelfie,
                            String userSignature,
                            String userEmail,
                            String userLicense) {
        userPassword=passwordEncoder.encode(userPassword);
        UserInfo userInfo=new UserInfo();
        userInfo.setUserTelephone(userTelephone);
        userInfo.setUserPassword(userPassword);
        userInfo.setUserAlipayAccount(userAlipayAccount);
        userInfo.setUserName(userName);
        userInfo.setUserGender(userGender);
        userInfo.setUserSelfie(userSelfie);
        userInfo.setUserSignature(userSignature);
        userInfo.setUserEmail(userEmail);
        userInfo.setUserLicense(userLicense);
        userInfoMapper.insertSelective(userInfo);
        return true;
    }

}
