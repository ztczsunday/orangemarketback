package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.*;
import com.orangeSoft.market.mapper.DataDictionaryMapper;
import com.orangeSoft.market.mapper.OrderStateflowMapper;
import com.orangeSoft.market.mapper.UserCommentMapper;
import com.orangeSoft.market.mapper.UserInfoMapper;
import com.orangeSoft.market.service.IAdminService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-19
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    OrderStateflowMapper orderStateflowMapper;
    @Autowired
    DataDictionaryMapper dataDictionaryMapper;
    @Autowired
    UserCommentMapper userCommentMapper;

    @Override
    public Result.JSONResultMap findUserAmount(){
        return Result.success(userInfoMapper.selectCount(new QueryWrapper<>()));
    }

    @Override
    public Result.JSONResultMap findOrderStatus(){
        Map<String, Integer> resultMap = new HashMap<>();
        QueryWrapper<OrderStateflow> orderStateflowQueryWrapper=new QueryWrapper<>();
        for (int i=1;i<=6;i++){
            orderStateflowQueryWrapper.clear();
            orderStateflowQueryWrapper.eq("record_id",i);
            resultMap.put(dataDictionaryMapper.selectById(i).getItemName(),orderStateflowMapper.selectCount(orderStateflowQueryWrapper));
        }
        return Result.success(resultMap);
    }

    @Override
    public Result.JSONResultMap findCommodityPraise(){
        Map<String,Integer> resultMap=new HashMap<>();
        QueryWrapper<UserComment> userCommentQueryWrapper=new QueryWrapper<>();
        resultMap.put("评价数",userCommentMapper.selectCount(userCommentQueryWrapper));
        userCommentQueryWrapper.eq("praise",true);
        resultMap.put("好评数",userCommentMapper.selectCount(userCommentQueryWrapper));
        return Result.success(resultMap);
    }

    @Override
    public Result.JSONResultMap findEverydayOrderAmount(int days){
        Map<LocalDateTime,Integer> resultMap=new HashMap<>();
        LocalDateTime localDateTime=LocalDateTime.now();
        for(int i=0;i<days;i++){
            resultMap.put(localDateTime,orderStateflowMapper.selectCount(new QueryWrapper<OrderStateflow>()
                    .eq("record_id",i)
                    .le("status_time",localDateTime)
                    .ge("status_time",localDateTime.minus(1, ChronoUnit.DAYS))));
        }
        return Result.success(resultMap);
    }
}
