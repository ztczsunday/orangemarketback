package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.Commodity;
import com.orangeSoft.market.entity.CommodityOrder;
import com.orangeSoft.market.pojo.OrderDetailResult;
import com.orangeSoft.market.pojo.UserOrderResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface CommodityOrderMapper extends BaseMapper<CommodityOrder> {

    OrderDetailResult findOrderDetailByOrderId(@Param("orderId") long orderId);

    IPage<UserOrderResult> findUserOrderByUserId(@Param("uid") Integer uid, IPage<UserOrderResult> page);

    int findSidBySubId(Integer subId);
}
