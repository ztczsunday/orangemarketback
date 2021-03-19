package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Footprint;
import com.orangeSoft.market.pojo.History;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IFootprintService extends IService<Footprint> {

    /**
     * 用户查看历史记录
     *
     * @param page 分页标签
     * @return 该页历史记录
     */
    IPage<History> findFootPrintByUid(Page<Footprint> page);

    /**
     * 删除历史记录
     *
     * @param cid 该历史记录对应的商品ID
     * @return 是否删除完成
     */
    Result.JSONResultMap deleteFootPrint(long cid);

    /**
     * 添加历史记录
     *
     * @param cid 该历史记录对应的商品ID
     * @return 是否添加完成
     */
    Result.JSONResultMap addFootPrint(long cid);
}
