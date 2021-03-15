package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.CommodityOrderMapper;
import com.orangeSoft.market.mapper.OrderLogisticsMapper;
import com.orangeSoft.market.mapper.OrderStateflowMapper;
import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import com.orangeSoft.market.service.ICommodityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class CommodityOrderServiceImpl extends ServiceImpl<CommodityOrderMapper, CommodityOrder> implements ICommodityOrderService {
    @Autowired
    CommodityOrderMapper commodityOrderMapper;

    public Result.JSONResultMap findOrderDetailByOrderId(long orderId) {
        OrderDetailResult orderDetailResult = commodityOrderMapper.findOrderDetailByOrderId(orderId);
        return Result.success(orderDetailResult);
    }

    public Result.JSONResultMap findUserOrderByUid() {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        List<UserOrderResult> userOrderResults = commodityOrderMapper.findUserOrderByUserId(userInfo.getUid());
        return Result.success(userOrderResults);
    }

    public Result.JSONResultMap deleteOrderByOrderId(long orderId){
        if (this.removeById(orderId)){
            return Result.success("","已删除");
        }
        return Result.fail();
    }
}
