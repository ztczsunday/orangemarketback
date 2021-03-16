package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.Commodity;

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
    IPage<Commodity> findCommodityByKey(Page<Commodity> page, String keyword);

    /**
     * 根据标签对商品进行分页查询
     *
     * @param page  要查询的分页器
     * @param label 商品标签
     * @return 分页的商品列表
     */
    IPage<Commodity> findCommodityByLabel(Page<Commodity> page, String label, Double minValue, Double maxValue);
}
