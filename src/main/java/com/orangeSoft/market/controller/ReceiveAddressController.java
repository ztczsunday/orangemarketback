package com.orangeSoft.market.controller;

import com.google.gson.Gson;
import com.orangeSoft.market.entity.ReceiveAddress;
import com.orangeSoft.market.service.impl.ReceiveAddressServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
public class ReceiveAddressController {
    @Autowired
    ReceiveAddressServiceImpl receiveAddressService;
    @ApiOperation(value = "查看用户所有收货地址",notes = "114514")
    @PostMapping(value = "/address", produces = "application/json;charset=UTF-8")
    public String findAddressByUid(){
        return new Gson().toJson(receiveAddressService.findAddressByUid());
    }
    @ApiOperation(value = "更新收货地址信息（包括默认地址）",notes = "114514")
    @ApiImplicitParam(name = "receiveAddress", dataType = "ReceiveAddress", value = "新收货地址")
    @ResponseBody
    @PostMapping(value = "/updateAddress", produces = "application/json;charset=UTF-8")
    public String updateReceiveAddress(@RequestBody ReceiveAddress updatedReceiveAddress){
        return new Gson().toJson(receiveAddressService.updateReceiveAddress(updatedReceiveAddress));
    }
    @ApiOperation(value = "添加收货地址",notes = "114514")
    @ApiImplicitParam(name = "receiveAddress", dataType = "ReceiveAddress", value = "新收货地址")
    @ResponseBody
    @PostMapping(value = "/insertAddress", produces = "application/json;charset=UTF-8")
    public String insertNewAddress(@RequestBody ReceiveAddress newReceiveAddress){
        return new Gson().toJson(receiveAddressService.insertNewAddress(newReceiveAddress));
    }
    @ApiOperation(value = "删除收货地址",notes = "114514")
    @PostMapping(value = "/deleteAddress", produces = "application/json;charset=UTF-8")
    public String deleteReceiveAddress(@RequestParam Integer receiveAddressId){
        return new Gson().toJson(receiveAddressService.deleteReceiveAddress(receiveAddressId));
    }
}
