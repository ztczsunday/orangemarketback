package com.orangeSoft.market.service;

import com.orangeSoft.market.mapper.extend.UserInfoMapperE;
import com.orangeSoft.market.pojo.UserInfo;
import com.orangeSoft.market.pojo.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//暂时注掉spring security相关
@Service
public class UserService {
    @Autowired
    private UserInfoMapperE userInfoMapperE;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    public UserInfo login(String account, String pwd){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserTelephoneEqualTo(account).andUserPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapperE.selectByExample(userInfoExample);
        return userInfos.isEmpty()?null:userInfos.get(0);
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
//        userPassword=passwordEncoder.encode(userPassword);
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
        userInfoMapperE.insertSelective(userInfo);
        return true;
    }

}
