package com.orangeSoft.market.controller;

import com.orangeSoft.market.common.utils.Result;
import com.orangeSoft.market.entity.ReceiveAddress;
import com.orangeSoft.market.service.impl.ReceiveAddressServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiveAddressController {
    @Autowired
    ReceiveAddressServiceImpl receiveAddressService;

    @ApiOperation(value = "查看用户所有收货地址")
    @GetMapping(value = "/address", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap findAddressByUid() {
        return receiveAddressService.findAddressByUid();
    }

    @ApiOperation(value = "更新收货地址信息（包括默认地址）")
    @ApiImplicitParam(name = "receiveAddress", dataType = "ReceiveAddress", value = "新收货地址")
    @PutMapping(value = "/address", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap updateReceiveAddress(@RequestBody ReceiveAddress updatedReceiveAddress) {
        return receiveAddressService.updateReceiveAddress(updatedReceiveAddress);
    }

    @ApiOperation(value = "添加收货地址")
    @ApiImplicitParam(name = "receiveAddress", dataType = "ReceiveAddress", value = "新收货地址", example = "0")
    @PostMapping(value = "/address", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap insertNewAddress(@RequestBody ReceiveAddress newReceiveAddress) {
        return receiveAddressService.insertNewAddress(newReceiveAddress);
    }

    @ApiOperation(value = "删除收货地址")
    @DeleteMapping(value = "/address", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap deleteReceiveAddress(@RequestParam Integer receiveAddressId) {
        return receiveAddressService.deleteReceiveAddress(receiveAddressId);
    }

    @ApiOperation(value = "查看默认收货地址")
    @GetMapping(value = "/defaultAddress", produces = "application/json;charset=UTF-8")
    public Result.JSONResultMap returnDefaultAddress() {
        return receiveAddressService.returnDefaultAddress();
    }
}
