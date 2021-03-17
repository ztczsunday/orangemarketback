package com.orangeSoft.market.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    UserCommentResult findAllCommentsByCid(Long cid);
}
