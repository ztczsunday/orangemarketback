package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.SubCommodity;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface ISubCommodityService extends IService<SubCommodity> {

    /**
     * 修改商品库存
     *
     * @param subId 种类ID
     * @param stock 库存
     * @return 修改是否成功
     */
    Result.JSONResultMap updateStock(int subId, int stock);
}
