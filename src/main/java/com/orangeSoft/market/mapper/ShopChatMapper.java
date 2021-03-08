package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.ShopChatExample;
import com.orangeSoft.market.pojo.ShopChatKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopChatMapper {
    long countByExample(ShopChatExample example);

    int deleteByExample(ShopChatExample example);

    int deleteByPrimaryKey(ShopChatKey key);

    int insert(ShopChatKey record);

    int insertSelective(ShopChatKey record);

    List<ShopChatKey> selectByExample(ShopChatExample example);

    int updateByExampleSelective(@Param("record") ShopChatKey record, @Param("example") ShopChatExample example);

    int updateByExample(@Param("record") ShopChatKey record, @Param("example") ShopChatExample example);
}