package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.pojo.CommoditySearchResult;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {
    IPage<CommoditySearchResult> findByLabel(IPage<CommoditySearchResult> page, String label, Double minValue, Double maxValue);
    IPage<CommoditySearchResult> findByKey(IPage<CommoditySearchResult> page, String keyword, Double minValue, Double maxValue);
}
