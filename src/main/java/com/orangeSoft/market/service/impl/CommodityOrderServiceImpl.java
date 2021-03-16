package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.entity.Shop;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.mapper.CommodityOrderMapper;
import com.orangeSoft.market.mapper.ShopMapper;
import com.orangeSoft.market.pojo.ShopOrderResult;
import com.orangeSoft.market.pojo.UserOrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import com.orangeSoft.market.service.ICommodityOrderService;
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
public class CommodityOrderServiceImpl extends ServiceImpl<CommodityOrderMapper, CommodityOrder> implements ICommodityOrderService {
    @Autowired
    CommodityOrderMapper commodityOrderMapper;
    @Autowired
    ShopMapper shopMapper;

    public Result.JSONResultMap findOrderDetailByOrderId(long orderId) {
        UserOrderDetailResult orderDetailResult = commodityOrderMapper.findOrderDetailByOrderId(orderId);
        return Result.success(orderDetailResult);
    }

    public Result.JSONResultMap findUserOrderByUid(Page<UserOrderResult> page) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        IPage<UserOrderResult> userOrderResults = commodityOrderMapper.findUserOrderByUserId(userInfo.getUid(), page);
        return Result.success(userOrderResults);
    }

    public Result.JSONResultMap addOrder(int subId, int receiveAddressId, int countCommodity) {
        CommodityOrder commodityOrder = new CommodityOrder();
        commodityOrder.setCountCommodity(countCommodity);
        commodityOrder.setReceiveAddressId(receiveAddressId);
        commodityOrder.setSubId(subId);
        commodityOrder.setSid(commodityOrderMapper.findSidBySubId(subId));
        commodityOrder.setUid(MySessionUtil.getCurrUser().getUid());
        if (this.save(commodityOrder)) {
            return Result.success();
        }
        return Result.fail();
    }

    public Result.JSONResultMap findShopOrderByUid(Page<ShopOrderResult> page){
        UserInfo userInfo=MySessionUtil.getCurrUser();
        Shop shop=shopMapper.selectOne(new QueryWrapper<Shop>().eq("uid",userInfo.getUid()));
        return Result.success(commodityOrderMapper.findShopOrderBySid(shop.getSid(),page));
    }
}
