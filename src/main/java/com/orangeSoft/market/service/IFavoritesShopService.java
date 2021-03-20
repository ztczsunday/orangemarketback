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
     * 查看收藏的店铺
     *
     * @param page 收藏夹分页
     * @return 用户收藏的商店信息
     */
    Result.JSONResultMap getMyFavoriteShop(Page<Shop> page);

    /**
     * 移除收藏的店铺
     *
     * @param sid 商店ID
     * @return 移除指定商店收藏
     */
    Result.JSONResultMap deleteFavoritesShop(int sid);

    /**
     * 收藏店铺
     *
     * @param sid 商店ID
     * @return 添加指定商店收藏
     */
    Result.JSONResultMap addFavoritesShop(int sid);

    /**
     * 查询当前用户是否收藏了该商店
     *
     * @param sid 商店ID
     * @return true收藏, false未收藏
     */
    boolean isShopCollected(Integer sid);
}
