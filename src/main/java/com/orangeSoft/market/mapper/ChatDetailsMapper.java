package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.ChatDetails;
import com.orangeSoft.market.pojo.ChatDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatDetailsMapper {
    long countByExample(ChatDetailsExample example);

    int deleteByExample(ChatDetailsExample example);

    int deleteByPrimaryKey(Long chatContentId);

    int insert(ChatDetails record);

    int insertSelective(ChatDetails record);

    List<ChatDetails> selectByExample(ChatDetailsExample example);

    ChatDetails selectByPrimaryKey(Long chatContentId);

    int updateByExampleSelective(@Param("record") ChatDetails record, @Param("example") ChatDetailsExample example);

    int updateByExample(@Param("record") ChatDetails record, @Param("example") ChatDetailsExample example);

    int updateByPrimaryKeySelective(ChatDetails record);

    int updateByPrimaryKey(ChatDetails record);
}