package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orangeSoft.market.entity.Chat;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 任意用户之间，或者店铺之间都能自由私信.	身份只有“用户”和“店铺” Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface ChatMapper extends BaseMapper<Chat> {

}
