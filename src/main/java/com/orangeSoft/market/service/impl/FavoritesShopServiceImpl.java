package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.FavoritesShop;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.mapper.FavoritesShopMapper;
import com.orangeSoft.market.service.IFavoritesShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class FavoritesShopServiceImpl extends ServiceImpl<FavoritesShopMapper, FavoritesShop> implements IFavoritesShopService {
    @Autowired
    FavoritesShopMapper favoritesShopMapper;

    @Override
    public Result.JSONResultMap getMyFavoriteShop(Page<Shop> page) {
        return Result.success(favoritesShopMapper.findFavoritesShopByUid(page, MySessionUtil.getCurrUser().getUid()));
    }

    @Override
    public Result.JSONResultMap deleteFavoritesShop(int sid) {
        QueryWrapper<FavoritesShop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", sid).eq("uid", MySessionUtil.getCurrUser().getUid());
        if (favoritesShopMapper.delete(queryWrapper) > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap addFavoritesShop(int sid) {
        FavoritesShop favoritesShop = new FavoritesShop();
        favoritesShop.setSid(sid);
        favoritesShop.setUid(MySessionUtil.getCurrUser().getUid());
        if (this.save(favoritesShop)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public boolean isShopCollected(Integer sid) {
        return this.query().eq("sid", sid).eq("uid", MySessionUtil.getCurrUser().getUid()).one() != null;
    }
}
