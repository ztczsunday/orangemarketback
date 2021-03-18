package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orangeSoft.market.entity.SubComments;
import com.orangeSoft.market.pojo.SubCommentsResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-16
 */
@Repository
public interface SubCommentsMapper extends BaseMapper<SubComments> {
    List<SubCommentsResult> findSubComments(Long commentId);

}
