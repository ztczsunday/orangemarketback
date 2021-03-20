package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Logistics;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface ILogisticsService extends IService<Logistics> {

    /**
     * 查看所有物流公司
     *
     * @return 物流公司信息
     */
    Result.JSONResultMap findAllLogistics();

    /**
     * 更新物流公司信息
     *
     * @param logistics 新物流公司信息
     * @return 是否更新完成
     */
    Result.JSONResultMap updateLogistics(Logistics logistics);

    /**
     * 添加物流公司
     *
     * @param logistics 新物流公司信息
     * @return 是否更新完成
     */
    Result.JSONResultMap insertLogistics(Logistics logistics);

    /**
     * 删除物流公司
     *
     * @param logisticsId 指定物流公司ID
     * @return 是否删除完成
     */
    Result.JSONResultMap deleteLogistics(Integer logisticsId);
}
