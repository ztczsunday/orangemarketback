package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.FavoritesCommodity;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IFavoritesCommodityService extends IService<FavoritesCommodity> {

    /**
     * 判断商品是否被用户收藏，用于内部使用
     *
     * @param commodityId 目标商品
     * @return 是否被当前用户收藏
     */
    Boolean isCollected(Long commodityId);

    /**
     * 查看收藏商品
     *
     * @param page 收藏商品栏分页
     * @return 所有被该用户收藏的商品
     */
    Result.JSONResultMap getMyFavoriteCommodity(Page<Commodity> page);

    /**
     * 移除收藏商品
     *
     * @param cid 移除指定收藏商品
     * @return 是否被成功移除
     */
    Result.JSONResultMap deleteFavoritesCommodity(long cid);

    /**
     * 收藏商品
     *
     * @param cid 添加指定收藏商品
     * @return 是否被成功收藏
     */
    Result.JSONResultMap addFavoritesCommodity(long cid);
}
