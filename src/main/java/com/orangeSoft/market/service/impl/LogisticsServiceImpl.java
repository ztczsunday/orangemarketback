package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Logistics;
import com.orangeSoft.market.mapper.LogisticsMapper;
import com.orangeSoft.market.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, Logistics> implements ILogisticsService {

    @Autowired
    LogisticsMapper logisticsMapper;

    @Override
    public Result.JSONResultMap findAllLogistics() {
        return Result.success(logisticsMapper.selectList(new QueryWrapper<Logistics>().orderBy(true, true, "logistics_id")));
    }

    @Override
    public Result.JSONResultMap updateLogistics(Logistics logistics) {
        if (this.updateById(logistics)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap insertLogistics(Logistics logistics) {
        if (this.save(logistics)) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap deleteLogistics(Integer logisticsId) {
        if (this.removeById(logisticsId)) {
            return Result.success();
        }
        return Result.fail();
    }
}
