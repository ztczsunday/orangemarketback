package com.orangeSoft.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orangeSoft.market.entity.Manager;
import com.orangeSoft.market.mapper.ManagerMapper;
import com.orangeSoft.market.service.IManagerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员专用账户 服务实现类
 * </p>
 *
 * @since 2021-03-13
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

}
