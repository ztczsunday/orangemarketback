package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserComment;
import com.orangeSoft.market.pojo.UserCommentResult;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @since 2021-03-13
 */
public interface IUserCommentService extends IService<UserComment> {
    /**
     * 评价商品
     *
     * @param cid            目标商品id
     * @param commentDetails 评价内容
     * @param praise         是否好评
     * @return 结果
     */
    Boolean evaluateCommodity(Long cid, String commentDetails, Boolean praise);

    /**
     * 查找当前用户所有的历史评价
     *
     * @return 结果
     */
    Result.JSONResultMap getMyAllComments();

    /**
     * 根据商品id查找其所有评论，包括评论人用户名以及头像，不包括子评论
     *
     * @param cid              目标商品
     * @param userCommentIPage 分页器
     * @return 结果
     */
    Result.JSONResultMap getAllCommentsByCid(IPage<UserCommentResult> userCommentIPage, Long cid);
}
