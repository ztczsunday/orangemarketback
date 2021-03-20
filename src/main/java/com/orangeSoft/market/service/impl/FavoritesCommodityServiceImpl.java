package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.FavoritesCommodity;
import com.orangeSoft.market.mapper.FavoritesCommodityMapper;
import com.orangeSoft.market.service.IFavoritesCommodityService;
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
public class FavoritesCommodityServiceImpl extends ServiceImpl<FavoritesCommodityMapper, FavoritesCommodity> implements IFavoritesCommodityService {
    @Autowired
    private FavoritesCommodityMapper favoritesCommodityMapper;

    @Override
    public Result.JSONResultMap getMyFavoriteCommodity(Page<Commodity> page) {
        return Result.success(favoritesCommodityMapper.findFavoritesCommodityByUid(page, MySessionUtil.getCurrUser().getUid()));
    }

    @Override
    public Result.JSONResultMap deleteFavoritesCommodity(long cid) {
        QueryWrapper<FavoritesCommodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", cid).eq("uid", MySessionUtil.getCurrUser().getUid());
        if (favoritesCommodityMapper.delete(queryWrapper) > 0) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap addFavoritesCommodity(long cid) {
        FavoritesCommodity favoritesCommodity = new FavoritesCommodity(MySessionUtil.getCurrUser().getUid(), cid);
        if (this.save(favoritesCommodity)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Boolean isCollected(Long commodityId) {
        return this.count(new QueryWrapper<FavoritesCommodity>()
                .eq("cid", commodityId)
                .eq("uid", MySessionUtil.getCurrUser().getUid())) > 0;
    }
}
