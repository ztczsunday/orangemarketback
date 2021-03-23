package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.pojo.CommoditySearchResult;
import com.orangeSoft.market.pojo.CommodityUpdateData;
import com.orangeSoft.market.pojo.NewCommodityData;

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
     * @param page     页码
     * @param pageSize 页面大小
     * @param sid      店铺ID
     * @return 结果
     */
    Result.JSONResultMap getShopDetailsBySid(int page, int pageSize, Integer sid);

    /**
     * 首页推荐商品
     *
     * @return 推荐商品列表
     */
    Result.JSONResultMap recommendCommodities();

    /**
     * 新建商品
     *
     * @param newCommodityData 新建商品信息，包括轮播图，商品种类信息
     * @return 是否添加完成
     */
    Result.JSONResultMap newCommodity(NewCommodityData newCommodityData);

    /**
     * 商家查看商品详细信息
     *
     * @param cid 需要查看的商品ID
     * @return 该商品的详细信息
     */
    Result.JSONResultMap getUpdatedCommodity(long cid);

    /**
     * 商家修改商品详细信息
     *
     * @param commodityUpdateData 商品被修改后的详细信息
     * @return 【是否完成
     */
    Result.JSONResultMap updatedCommodity(CommodityUpdateData commodityUpdateData);
}
