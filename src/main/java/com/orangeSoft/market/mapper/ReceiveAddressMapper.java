package com.orangeSoft.market.mapper;

import com.orangeSoft.market.pojo.ReceiveAddress;
import com.orangeSoft.market.pojo.ReceiveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveAddressMapper {
    long countByExample(ReceiveAddressExample example);

    int deleteByExample(ReceiveAddressExample example);

    int deleteByPrimaryKey(Integer receiveAddressId);

    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    List<ReceiveAddress> selectByExample(ReceiveAddressExample example);

    ReceiveAddress selectByPrimaryKey(Integer receiveAddressId);

    int updateByExampleSelective(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByExample(@Param("record") ReceiveAddress record, @Param("example") ReceiveAddressExample example);

    int updateByPrimaryKeySelective(ReceiveAddress record);

    int updateByPrimaryKey(ReceiveAddress record);
}