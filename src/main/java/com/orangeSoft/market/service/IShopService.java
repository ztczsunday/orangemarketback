package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
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
     * @param newShop 注册商店的基本信息
     * @return 是否创建成功
     */
    Result.JSONResultMap registerShop(Shop newShop);

    /**
     * @param newShop 商店更新信息
     * @return 是否更新成功
     */
    Result.JSONResultMap updateShop(Shop newShop);

    /**
     * @param page 商店界面分页
     * @return 商店商品基本信息
     */
    Result.JSONResultMap shopCommodity(Page<Commodity> page);
}
