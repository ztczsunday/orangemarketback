package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.UserChatExample;
import com.orangeSoft.market.pojo.UserChatKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChatMapper {
    long countByExample(UserChatExample example);

    int deleteByExample(UserChatExample example);

    int deleteByPrimaryKey(UserChatKey key);

    int insert(UserChatKey record);

    int insertSelective(UserChatKey record);

    List<UserChatKey> selectByExample(UserChatExample example);

    int updateByExampleSelective(@Param("record") UserChatKey record, @Param("example") UserChatExample example);

    int updateByExample(@Param("record") UserChatKey record, @Param("example") UserChatExample example);
}