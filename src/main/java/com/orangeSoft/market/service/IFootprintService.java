package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.Footprint;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IFootprintService extends IService<Footprint> {
    /**
     * <p>
     * 按分页查询历史记录
     * </p>
     *
     * @param page 分页参数
     * @return 结果
     */
    IPage<Commodity> findFootPrintByUid(Page<Footprint> page);

    /**
     * <p>
     * 增加历史记录
     * </p>
     *
     * @param cid 历史记录中需要记录浏览的商品
     * @return 成功插入则返回true，否则返回false
     */
    boolean addFootPrint(long cid);
}
