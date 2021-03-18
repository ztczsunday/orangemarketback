package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.pojo.CommoditySearchResult;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface ICommodityService extends IService<Commodity> {
    /**
     * 根据关键词对商品进行分页查询(搜索)
     *
     * @param page    要查询的分页器
     * @param keyword 关键词
     * @return 分页的商品列表
     */
    IPage<CommoditySearchResult> findCommodityByKey(Page<CommoditySearchResult> page, String keyword, Double minValue, Double maxValue, String orderColumn);

    /**
     * 根据标签对商品进行分页查询
     *
     * @param page  要查询的分页器
     * @param label 商品标签
     * @return 分页的商品列表
     */
    IPage<CommoditySearchResult> findCommodityByLabel(Page<CommoditySearchResult> page, String label, Double minValue, Double maxValue, String orderColumn);

    /**
     * 根据商品ID查找商品详情
     *
     * @param commodityId 商品ID
     * @return Result
     */
    Result.JSONResultMap getCommodityById(Long commodityId);

    /**
     * 查询店铺所有商品，按出售中以及已下架分开，同时包含最低价格
     *
     * @param sid 店铺ID
     * @param page 分页器
     * @return 结果
     */
    Result.JSONResultMap getCommodityBtSid(IPage<CommoditySearchResult> page, Integer sid);

    Result.JSONResultMap recommendCommodities();
}
