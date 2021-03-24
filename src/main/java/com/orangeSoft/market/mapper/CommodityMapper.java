package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.pojo.CommoditySearchResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {
    IPage<CommoditySearchResult> findByLabel(IPage<CommoditySearchResult> page, String label, Double minValue, Double maxValue, String orderColumn);

    IPage<CommoditySearchResult> findByKey(IPage<CommoditySearchResult> page, String keyword, Double minValue, Double maxValue, String orderColumn);

    IPage<CommoditySearchResult> findCommodityBySidOpen(IPage<CommoditySearchResult> page, Integer sid);

    IPage<CommoditySearchResult> findCommodityBySidClose(IPage<CommoditySearchResult> page, Integer sid);

    List<Commodity> findRecommends(Long recordId);

    List<Commodity> findNewRecommends();

    Integer updateCommentsCount(Long cid, boolean praise);
}
