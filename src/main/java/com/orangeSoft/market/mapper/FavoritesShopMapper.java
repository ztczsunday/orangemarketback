package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orangeSoft.market.entity.FavoritesShop;
import com.orangeSoft.market.entity.Shop;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface FavoritesShopMapper extends BaseMapper<FavoritesShop> {

    IPage<Shop> findFavoritesShopByUid(Page<Shop> page, Integer uid);
}
