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
    public Result.JSONResultMap register(UserInfo userInfo) {
        if (this.save(userInfo)) {
    public Result.JSONResultMap register(UserInfo userInfo) {
        userInfo.setUid(null);
        if (this.save(userInfo)) {
            return Result.success();
        }
        return Result.fail();
    }

    public Result.JSONResultMap findUserInfoByUid() {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        return Result.success(userInfo);
    }

    public Result.JSONResultMap updateUserInfo(UserInfo newUserInfo) {
        if (this.updateById(newUserInfo)) {
            return Result.success();
        }
        return Result.fail();
    }


}
