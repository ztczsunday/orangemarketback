package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.*;
import com.orangeSoft.market.mapper.*;
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
    public IPage<Commodity> findCommodityByKey(Page<Commodity> page, String keyword) {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.like("commodity_name", keyword);
        return commodityMapper.selectPage(page, wrapper);
    }

    @Override
    public IPage<Commodity> findCommodityByLabel(Page<Commodity> page, String label, Double minValue, Double maxValue) {
        return commodityMapper.findByLabel(page, label, minValue, maxValue);
    }

    @Override
    public Result.JSONResultMap getCommodityById(Integer commodityId) {
        Map<String, Object> result = new HashMap<>();
        QueryWrapper<CommodityDetails> detailsQueryWrapper = new QueryWrapper<>();
        detailsQueryWrapper.eq("cid", commodityId);
        result.put("commodityDetails", commodityDetailsMapper.selectList(detailsQueryWrapper));

        QueryWrapper<CommodityPictures> picturesQueryWrapper = new QueryWrapper<>();
        picturesQueryWrapper.eq("cid", commodityId);
        result.put("commodityPictures", commodityPicturesMapper.selectList(picturesQueryWrapper));

        QueryWrapper<SubCommodity> subQueryWrapper = new QueryWrapper<>();
        subQueryWrapper.eq("cid", commodityId);
        result.put("subCommodity", subCommodityMapper.selectList(subQueryWrapper));

        QueryWrapper<UserComment> userCommentQueryWrapper = new QueryWrapper<>();
        userCommentQueryWrapper.eq("cid", commodityId);
        userCommentQueryWrapper.orderByDesc("comment_time");
        userCommentQueryWrapper.last("limit 3");
        result.put("hotComments", userCommentMapper.selectList(userCommentQueryWrapper));
        return Result.success(result);
    }
}
