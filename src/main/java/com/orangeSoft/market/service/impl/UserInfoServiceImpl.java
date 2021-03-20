package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.UserInfoMapper;
import com.orangeSoft.market.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 所有用户 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Override
    public Result.JSONResultMap register(UserInfo userInfo) {
        userInfo.setUid(null);
        if ("".equals(userInfo.getUserTelephone()) || "".equals(userInfo.getPassword()) || "".equals(userInfo.getUsername())) {
            return Result.fail(null, "用户名、密码、手机号不能为空");
        } else if (this.query().eq("user_telephone", userInfo.getUserTelephone()).count() != 0) {
            return Result.fail(null, "该手机号已被注册");
        } else if (userInfo.getPassword().length() > 16 || userInfo.getPassword().length() < 8) {
            return Result.fail(null, "密码格式错误");
        } else if (this.save(userInfo)) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @Override
    public Result.JSONResultMap findUserInfoByUid() {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        return Result.success(userInfo);
    }

    @Override
    public Result.JSONResultMap updateUserInfo(UserInfo newUserInfo) {
        if (this.updateById(newUserInfo)) {
            return Result.success();
        }
        return Result.fail();
    }


}
