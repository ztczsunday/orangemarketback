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
     * 用户创建商店
     *
     * @param newShop 注册商店的基本信息
     * @return 是否创建成功
     */
    Result.JSONResultMap registerShop(Shop newShop);

    /**
     * 更新商店信息
     *
     * @param newShop 商店更新信息
     * @return 是否更新成功
     */
    Result.JSONResultMap updateShop(Shop newShop);

    /**
     * 商店首页
     *
     * @param page 商店界面分页
     * @return 商店商品基本信息
     */
    Result.JSONResultMap shopCommodity(Page<Commodity> page);

    /**
     * 根据店铺id查询店铺
     *
     * @param sid 目标店铺
     * @return 目标店铺
     */
    Shop getShopById(Integer sid);

    /**
     * 修改商店简介
     *
     * @param sid             店铺号
     * @param shopDescription 店铺简介
     * @return 是否修改完成
     */
    Result.JSONResultMap updateShopDescription(Integer sid, String shopDescription);
}
