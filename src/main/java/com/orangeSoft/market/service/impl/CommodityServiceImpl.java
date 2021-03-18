package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.*;
import com.orangeSoft.market.mapper.*;
import com.orangeSoft.market.pojo.CommoditySearchResult;
import com.orangeSoft.market.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityDetailsMapper commodityDetailsMapper;
    @Autowired
    private CommodityPicturesMapper commodityPicturesMapper;
    @Autowired
    private SubCommodityMapper subCommodityMapper;
    @Autowired
    private UserCommentMapper userCommentMapper;

    @Override
    public IPage<CommoditySearchResult> findCommodityByKey(Page<CommoditySearchResult> page, String keyword, Double minValue, Double maxValue) {
        return commodityMapper.findByKey(page, keyword, minValue, maxValue);
    }

    @Override
    public IPage<CommoditySearchResult> findCommodityByLabel(Page<CommoditySearchResult> page, String label, Double minValue, Double maxValue) {
        return commodityMapper.findByLabel(page, label, minValue, maxValue);
    }

    @Override
    public Result.JSONResultMap getCommodityById(Long commodityId) {
        Map<String, Object> result = new HashMap<>();

        result.put("commodityDetails", commodityDetailsMapper
                .selectList(new QueryWrapper<CommodityDetails>().eq("cid", commodityId)));

        result.put("commodityPictures", commodityPicturesMapper
                .selectList(new QueryWrapper<CommodityPictures>().eq("cid", commodityId)));

        result.put("subCommodity", subCommodityMapper
                .selectList(new QueryWrapper<SubCommodity>().eq("cid", commodityId)));

        result.put("hotComments", userCommentMapper
                .selectList(new QueryWrapper<UserComment>()
                        .eq("cid", commodityId)
                        .orderByDesc("comment_time")
                        .last("limit 3")));

        result.put("isCollected", new FavoritesCommodityServiceImpl().isCollected(commodityId));

        Shop shop = new ShopServiceImpl().getShopById(this.query().eq("cid", commodityId).one().getSid());
        result.put("shopName", shop.getShopName());
        result.put("shopDescription", shop.getShopDescription());

        return Result.success(result);
    }

    @Override
    public Result.JSONResultMap getCommodityBtSid(IPage<CommoditySearchResult> page, Integer sid) {
        Map<String, IPage<CommoditySearchResult>> rs = new HashMap<>();
        IPage<CommoditySearchResult> commodityOpen = this.baseMapper.findCommodityBySidOpen(page, sid);
        IPage<CommoditySearchResult> commodityClose = this.baseMapper.findCommodityBySidClose(page, sid);
        rs.put("commodityOpen", commodityOpen);
        rs.put("commodityClose", commodityClose);
        return Result.success(rs);
    }
}
