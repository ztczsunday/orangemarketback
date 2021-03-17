package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.UserComment;

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
     * 根据商品id查找其所有评论，不包括子评论
     *
     * @param cid 目标商品
     * @return 结果
     */
    Result.JSONResultMap getAllCommentsByCid(Long cid);
}
