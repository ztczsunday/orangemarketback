package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.CommodityLabel;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface ICommodityLabelService extends IService<CommodityLabel> {
    /**
     * 查找商品所有标签
     *
     * @param cid 商品ID
     * @return 商品标签列表
     */
    List<CommodityLabel> getLabelsByCid(Long cid);
}
