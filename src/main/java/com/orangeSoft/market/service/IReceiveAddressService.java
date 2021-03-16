package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.ReceiveAddress;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IReceiveAddressService extends IService<ReceiveAddress> {
    /**
     * @return 用户所有的收货地址
     */
    Result.JSONResultMap findAddressByUid();

    /**
     * @param newReceiveAddress 新的收货地址
     * @return 是否添加完成
     */
    Result.JSONResultMap insertNewAddress(ReceiveAddress newReceiveAddress);

    /**
     * @param updatedReceiveAddress 更新收货地址信息
     * @return 是否更新完成
     */
    Result.JSONResultMap updateReceiveAddress(ReceiveAddress updatedReceiveAddress);

    /**
     * @param receiveAddressId 指定收货地址ID
     * @return 是否移除指定收货地址
     */
    Result.JSONResultMap deleteReceiveAddress(int receiveAddressId);
}
