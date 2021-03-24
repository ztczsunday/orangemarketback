package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.SubCommodity;
import com.orangeSoft.market.mapper.SubCommodityMapper;
import com.orangeSoft.market.service.ISubCommodityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class SubCommodityServiceImpl extends ServiceImpl<SubCommodityMapper, SubCommodity> implements ISubCommodityService {

    @Override
    public Result.JSONResultMap updateStock(int subId, int stock) {
        SubCommodity subCommodity = this.getById(subId);
        subCommodity.setStock(stock);
        if (this.updateById(subCommodity)) {
            return Result.success();
        }
        return Result.fail();
    }
}
