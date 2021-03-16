package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.FavoritesShop;
import com.orangeSoft.market.entity.Shop;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IFavoritesShopService extends IService<FavoritesShop> {
    /**
     *
     * @param page 收藏夹分页
     * @return 用户收藏的商店信息
     */
    Result.JSONResultMap getMyFavoriteShop(Page<Shop> page);

    /**
     *
     * @param sid 商店ID
     * @return 移除指定商店收藏
     */
    Result.JSONResultMap deleteFavoritesShop(int sid);

    /**
     *
     * @param sid 商店ID
     * @return 添加指定商店收藏
     */
    Result.JSONResultMap addFavoritesShop(int sid);
}
