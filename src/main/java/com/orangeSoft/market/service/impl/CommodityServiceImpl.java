package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.CommodityDetails;
import com.orangeSoft.market.entity.CommodityPictures;
import com.orangeSoft.market.entity.SubCommodity;
import com.orangeSoft.market.mapper.CommodityDetailsMapper;
import com.orangeSoft.market.mapper.CommodityMapper;
import com.orangeSoft.market.mapper.CommodityPicturesMapper;
import com.orangeSoft.market.mapper.SubCommodityMapper;
import com.orangeSoft.market.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    public IPage<Commodity> findCommodityByKey(Page<Commodity> page, String keyword) {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.like("commodity_name", keyword);
        return commodityMapper.selectPage(page, wrapper);
    }

    public IPage<Commodity> findCommodityByLabel(Page<Commodity> page, String label, Double minValue, Double maxValue) {
        return commodityMapper.findByLabel(page, label, minValue, maxValue);
    }

    public Result.JSONResultMap getCommodityById(Integer commodityId) {
        QueryWrapper<CommodityDetails> detailsQueryWrapper = new QueryWrapper<>();
        detailsQueryWrapper.eq("cid", commodityId);
        List<CommodityDetails> detailsList = commodityDetailsMapper.selectList(detailsQueryWrapper);

        QueryWrapper<CommodityPictures> picturesQueryWrapper = new QueryWrapper<>();
        picturesQueryWrapper.eq("cid", commodityId);
        List<CommodityPictures> picturesList = commodityPicturesMapper.selectList(picturesQueryWrapper);

        QueryWrapper<SubCommodity> subQueryWrapper = new QueryWrapper<>();
        subQueryWrapper.eq("cid", commodityId);
        List<SubCommodity> subCommodityList = subCommodityMapper.selectList(subQueryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("commodityDetails", detailsList);
        result.put("commodityPictures", picturesList);
        result.put("subCommodity", subCommodityList);
        return Result.success(result);
    }
}
