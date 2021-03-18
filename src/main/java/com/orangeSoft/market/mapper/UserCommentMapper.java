package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.orangeSoft.market.entity.UserComment;
import com.orangeSoft.market.pojo.UserCommentResult;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2021-03-13
 */
@Repository
public interface UserCommentMapper extends BaseMapper<UserComment> {
    IPage<UserCommentResult> findAllCommentsByCid(IPage<UserCommentResult> userCommentIPage, Long cid);
}
