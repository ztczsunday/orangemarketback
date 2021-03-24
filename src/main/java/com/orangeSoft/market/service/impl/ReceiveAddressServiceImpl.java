package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.ReceiveAddress;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.ReceiveAddressMapper;
import com.orangeSoft.market.service.IReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class ReceiveAddressServiceImpl extends ServiceImpl<ReceiveAddressMapper, ReceiveAddress> implements IReceiveAddressService {

    @Autowired
    ReceiveAddressMapper receiveAddressMapper;

    @Override
    public Result.JSONResultMap findAddressByUid() {
        QueryWrapper<ReceiveAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", MySessionUtil.getCurrUser().getUid()).eq("is_deleted",false);
        if (receiveAddressMapper.selectCount(queryWrapper) == 0) {
            return Result.fail("", "没有设置收货地址");
        }
        return Result.success(receiveAddressMapper.selectList(queryWrapper));
    }

    @Override
    public Result.JSONResultMap insertNewAddress(ReceiveAddress newReceiveAddress) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        newReceiveAddress.setUid(userInfo.getUid());
        QueryWrapper<ReceiveAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("uid", userInfo.getUid()).eq("is_default", true).eq("is_deleted",false);
        if (receiveAddressMapper.selectCount(wrapper) == 0) {
            newReceiveAddress.setIsDefault(true);
        }else{
            ReceiveAddress defaultReceiveAddress=receiveAddressMapper.selectOne(wrapper);
            defaultReceiveAddress.setIsDefault(false);
            this.updateById(defaultReceiveAddress);
        }
        if (this.save(newReceiveAddress)) {
            return Result.success("", "已新建地址");
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap updateReceiveAddress(ReceiveAddress updatedReceiveAddress) {
        updatedReceiveAddress.setUid(MySessionUtil.getCurrUser().getUid());
        QueryWrapper<ReceiveAddress> wrapper = new QueryWrapper<>();
        if (updatedReceiveAddress.getIsDefault()) {
            wrapper.eq("is_default", true).eq("is_deleted",false);
            ReceiveAddress oldDefaultAddress = this.getOne(wrapper);
            oldDefaultAddress.setIsDefault(false);
            this.updateById(oldDefaultAddress);
        }
        wrapper.clear();
        wrapper.eq("receive_address_id", updatedReceiveAddress.getReceiveAddressId());
        if (this.update(updatedReceiveAddress, wrapper)) {
            return Result.success("", "已更新");
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap deleteReceiveAddress(int receiveAddressId) {
        ReceiveAddress receiveAddress = this.getById(receiveAddressId);
        if (receiveAddress.getIsDefault()) {
            QueryWrapper<ReceiveAddress> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uid", MySessionUtil.getCurrUser().getUid()).ne("receive_address_id", receiveAddressId).eq("is_deleted",false);
            List<ReceiveAddress> receiveAddressList = receiveAddressMapper.selectList(queryWrapper);
            if (!receiveAddressList.isEmpty()) {
                receiveAddressList.get(0).setIsDefault(true);
                receiveAddressMapper.updateById(receiveAddressList.get(0));
            }
        }
        receiveAddress.setIsDeleted(true);
        receiveAddress.setIsDefault(false);
        if (this.updateById(receiveAddress)){
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap returnDefaultAddress() {
        QueryWrapper<ReceiveAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", MySessionUtil.getCurrUser().getUid()).eq("is_default", true);
        if (receiveAddressMapper.selectCount(queryWrapper) == 0) {
            return Result.fail("", "没有设置收货地址");
        }
        return Result.success(receiveAddressMapper.selectOne(queryWrapper));
    }
}
