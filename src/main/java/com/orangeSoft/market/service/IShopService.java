package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.Shop;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IShopService extends IService<Shop> {
    /**
     * 根据店铺id查询店铺
     *
     * @param sid 目标店铺
     * @return 目标店铺
     */
    Shop getShopById(Integer sid);
}
