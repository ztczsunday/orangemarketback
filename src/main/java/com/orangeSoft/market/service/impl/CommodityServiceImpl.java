package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.mapper.CommodityMapper;
import com.orangeSoft.market.service.ICommodityService;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    public IPage<Commodity> findCommodityByKey(Page<Commodity> page, String keyword) {
        QueryWrapper<Commodity> wrapper = new QueryWrapper<>();
        wrapper.like("commodity_name", keyword);
        return commodityMapper.selectPage(page, wrapper);
    }

    public IPage<Commodity> findCommodityByLabel(Page<Commodity> page, String label, Double minValue, Double maxValue) {
        return commodityMapper.findByLabel(page, label, minValue, maxValue);
    }
}
