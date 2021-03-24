package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.SubComments;
import com.orangeSoft.market.entity.UserInfo;
import com.orangeSoft.market.service.impl.ChatServiceImpl;
import com.orangeSoft.market.service.impl.SubCommentsServiceImpl;
import com.orangeSoft.market.service.impl.UserCommentServiceImpl;
import com.orangeSoft.market.service.impl.UserInfoServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    UserCommentServiceImpl userCommentService;
    @Autowired
    SubCommentsServiceImpl subCommentsService;
    @Autowired
    ChatServiceImpl chatService;

    @ApiOperation(value = "查找用户信息")
    @GetMapping(value = "/userInfo", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findAddressByUid() {
        return userInfoService.findUserInfoByUid();
    }

    @ApiOperation(value = "用户数据更新", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息", example = "0")
    @PutMapping(value = "/userInfo", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap userUpdate(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

    @ApiOperation(value = "注册接口", notes = "114514")
    @ApiImplicitParam(name = "userInfo", dataType = "UserInfo", value = "用户信息")
    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap register(@RequestBody UserInfo userInfo) {
        return userInfoService.register(userInfo);
    }

    @ApiOperation(value = "用户评价商品", notes = "未传入评价内容则默认好评和默认评论")
    @PostMapping(value = "/user/comment", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap evaluateCommodity(
            @RequestParam(value = "cid") Long cid,
            @RequestParam(value = "commentDetails", defaultValue = "该用户没有填写任何评价，默认好评。") String commentDetails,
            @RequestParam(value = "praise", defaultValue = "true") Boolean praise) {
        return Result.success(userCommentService.evaluateCommodity(cid, commentDetails, praise));
    }

    @ApiOperation(value = "追加子评论", notes = "自动覆盖设置时间和状态,只需subCommentDetails,commentId,uid")
    @ApiImplicitParam(name = "subComments", dataType = "SubComments", value = "子评论")
    @PostMapping(value = "/user/comment/comments", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap subEvaluation(@RequestBody SubComments subComments) {
        return Result.success(subCommentsService.subEvaluation(subComments));
    }

    @ApiOperation(value = "查看当前用户所有评论", notes = "不包括回复别人的子评论")
    @PostMapping(value = "/user/myComments", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getMyAllComments() {
        return userCommentService.getMyAllComments();
    }

    @ApiOperation(value = "查看当前用户最新聊天", notes = "包含一条最新的消息")
    @GetMapping(value = "/user/aboutChats", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getAboutChats() {
        return chatService.getAboutChats();
    }

    @ApiOperation(value = "查看来信", notes = "点击最新消息进入，从中获取对方uid以及身份")
    @GetMapping(value = "/user/receiveChats", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap getAllChatsWithOpp(@RequestParam(value = "oppUid") Integer oppUid,
                                                   @RequestParam(value = "oppType") String oppType,
                                                   @RequestParam(value = "selfType") String selfType) {
        return chatService.getAllChatsWithOpp(oppUid, oppType, selfType);
    }

    @ApiOperation(value = "发送私信", notes = "对方uid和sid二选一，对应向用户和向店铺发送私信")
    @PostMapping(value = "/user/sendChat", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap sendChat(@RequestParam(value = "myType") String myType,
                                         @RequestParam(value = "oppId") Integer oppId,
                                         @RequestParam(value = "oppType") String oppType,
                                         @RequestParam(value = "chatContent") String chatContent) {
        return chatService.sendChat(myType, oppId, oppType, chatContent);
    }


}
