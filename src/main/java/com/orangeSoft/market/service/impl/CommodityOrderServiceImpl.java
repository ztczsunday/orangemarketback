package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.MySessionUtil;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.*;
import com.orangeSoft.market.mapper.*;
import com.orangeSoft.market.pojo.ShopOrderResult;
import com.orangeSoft.market.pojo.UserOrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import com.orangeSoft.market.service.ICommodityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    OrderStateflowMapper orderStateflowMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    SubCommodityMapper subCommodityMapper;
    @Autowired
    OrderLogisticsMapper orderLogisticsMapper;

    @Override
    public Result.JSONResultMap findOrderDetailByOrderId(long orderId) {
        UserOrderDetailResult orderDetailResult = commodityOrderMapper.findOrderDetailByOrderId(orderId);
        QueryWrapper<OrderStateflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId).orderBy(true, false, "record_id");
        List<OrderStateflow> orderStateflows = orderStateflowMapper.selectList(queryWrapper);
        Map<String, Object> map = new HashMap<>();
        map.put("order", orderDetailResult);
        map.put("state", orderStateflows);
        return Result.success(map, "订单详情");
    }

    @Override
    public Result.JSONResultMap findUserOrderByUid(Page<UserOrderResult> page) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        IPage<UserOrderResult> userOrderResults = commodityOrderMapper.findUserOrderByUserId(userInfo.getUid(), page);
        return Result.success(userOrderResults);
    }

    @Override
    public Result.JSONResultMap addOrder(int subId, int receiveAddressId, int countCommodity, int orderLogisticsId) {
        CommodityOrder commodityOrder = new CommodityOrder();
        commodityOrder.setCountCommodity(countCommodity);
        commodityOrder.setReceiveAddressId(receiveAddressId);
        commodityOrder.setSubId(subId);
        SubCommodity subCommodity = subCommodityMapper.selectById(subId);
        subCommodity.setStock(subCommodity.getStock() - countCommodity);
        if (subCommodity.getStock() < 0) {
            return Result.fail("", "货已卖空");
        }
        subCommodityMapper.updateById(subCommodity);
        commodityOrder.setSid(commodityOrderMapper.findSidBySubId(subId));
        commodityOrder.setUid(MySessionUtil.getCurrUser().getUid());
        OrderLogistics orderLogistics = new OrderLogistics();
        OrderStateflow orderStateflow = new OrderStateflow();

        if (commodityOrderMapper.insert(commodityOrder) == 1) {
            orderLogistics.setOrderId(commodityOrder.getOrderId());
            orderLogistics.setLogisticsId(orderLogisticsId);
            orderStateflow.setRecordId((long) 1);
            orderStateflow.setOrderId(commodityOrder.getOrderId());
            if ((orderLogisticsMapper.insert(orderLogistics) == 1) && orderStateflowMapper.insert(orderStateflow) == 1) {
                return Result.success(commodityOrder.getOrderId());
            }
        }
        return Result.fail();
    }

    @Override
    public Result.JSONResultMap findShopOrder(Page<ShopOrderResult> page) {
        UserInfo userInfo = MySessionUtil.getCurrUser();
        Shop shop = shopMapper.selectOne(new QueryWrapper<Shop>().eq("uid", userInfo.getUid()));
        return Result.success(commodityOrderMapper.findShopOrderBySid(shop.getSid(), page));
    }
}
