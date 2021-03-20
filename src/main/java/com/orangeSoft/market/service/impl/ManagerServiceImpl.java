package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.Manager;
import com.orangeSoft.market.entity.OrderStateflow;
import com.orangeSoft.market.entity.UserComment;
import com.orangeSoft.market.mapper.*;
import com.orangeSoft.market.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2021-03-19
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    OrderStateflowMapper orderStateflowMapper;
    @Autowired
    DataDictionaryMapper dataDictionaryMapper;
    @Autowired
    UserCommentMapper userCommentMapper;
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Result.JSONResultMap findUserAmount() {
        return Result.success(userInfoMapper.selectCount(new QueryWrapper<>()));
    }

    @Override
    public Result.JSONResultMap findOrderStatus() {
        Map<String, Integer> resultMap = new HashMap<>();
        QueryWrapper<OrderStateflow> orderStateflowQueryWrapper = new QueryWrapper<>();
        for (int i = 1; i <= 6; i++) {
            orderStateflowQueryWrapper.clear();
            orderStateflowQueryWrapper.eq("record_id", i);
            resultMap.put(dataDictionaryMapper.selectById(i).getItemName(), orderStateflowMapper.selectCount(orderStateflowQueryWrapper));
        }
        return Result.success(resultMap);
    }

    @Override
    public Result.JSONResultMap findCommodityPraise() {
        Map<String, Integer> resultMap = new HashMap<>();
        QueryWrapper<UserComment> userCommentQueryWrapper = new QueryWrapper<>();
        resultMap.put("评价数", userCommentMapper.selectCount(userCommentQueryWrapper));
        userCommentQueryWrapper.eq("praise", true);
        resultMap.put("好评数", userCommentMapper.selectCount(userCommentQueryWrapper));
        return Result.success(resultMap);
    }

    @Override
    public Result.JSONResultMap findEverydayOrderAmount(int days, int recordId) {
        Map<LocalDateTime, Integer> resultMap = new HashMap<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < days; i++) {
            resultMap.put(localDateTime, orderStateflowMapper.selectCount(new QueryWrapper<OrderStateflow>()
                    .eq("record_id", recordId)
                    .le("status_time", localDateTime)
                    .ge("status_time", localDateTime.minus(1, ChronoUnit.DAYS))));
        }
        return Result.success(resultMap);
    }

    @Override
    public Result.JSONResultMap managerLogin(String managerAccount, String managerPassword) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manager_account", managerAccount).eq("manager_password", managerPassword);
        if (managerMapper.selectCount(queryWrapper) == 1) {
            return Result.success();
        }
        return Result.fail();
    }


}
