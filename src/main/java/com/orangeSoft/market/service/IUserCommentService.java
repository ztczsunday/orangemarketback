package com.orangeSoft.market.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orangeSoft.market.entity.SubComments;
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

}
