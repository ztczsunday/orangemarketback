package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.CommodityMapper;
import com.orangeSoft.market.mapper.FavoritesShopMapper;
import com.orangeSoft.market.mapper.ShopMapper;
import com.orangeSoft.market.service.IShopService;
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
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    ShopMapper shopMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    FavoritesShopMapper favoritesShopMapper;

    @Override
    public Result.JSONResultMap registerShop(Shop newShop) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", userInfo.getUid());
        if (shopMapper.selectCount(queryWrapper) != 0) {
            return Result.fail("", "已有商店");
        }
        newShop.setUid(userInfo.getUid());
        if (this.save(newShop)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap updateShop(Shop newShop) {
        newShop.setUid(MySessionUtil.getCurrUser().getUid());
        if (this.updateById(newShop)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap shopCommodity(Page<Commodity> page) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        QueryWrapper<Shop> shopQueryWrapper = new QueryWrapper<>();
        shopQueryWrapper.eq("uid", userInfo.getUid());
        Shop myShop = shopMapper.selectOne(shopQueryWrapper);
        QueryWrapper<Commodity> commodityQueryWrapper = new QueryWrapper<>();
        commodityQueryWrapper.eq("sid", myShop.getSid()).orderBy(true, false, "comment_count");
        return Result.success(commodityMapper.selectPage(page, commodityQueryWrapper));
    }

    @Override
    public Shop getShopById(Integer sid) {
        return this.query().eq("sid", sid).one();
    }

    @Override
    public Result.JSONResultMap updateShopDescription(Integer sid, String shopDescription) {
        Shop shop = this.getById(sid);
        shop.setShopDescription(shopDescription);
        if (this.updateById(shop)) {
            return Result.success();
        }
        return Result.fail();
    }
}
