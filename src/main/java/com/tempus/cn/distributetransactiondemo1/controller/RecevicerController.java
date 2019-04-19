package com.tempus.cn.distributetransactiondemo1.controller;

import com.alibaba.fastjson.JSON;
import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import com.tempus.cn.distributetransactiondemo1.model.OrderModel;
import com.tempus.cn.distributetransactiondemo1.model.Result;
import com.tempus.cn.distributetransactiondemo1.service.IDeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/create")
public class RecevicerController {

    @Autowired
    IDeliveryOrderService deliveryOrderService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Result test(@RequestBody String aa){
        OrderModel orderModel = JSON.parseObject(aa,OrderModel.class);
        DeliveryOrderModel deliveryOrderModel = new DeliveryOrderModel();
        deliveryOrderModel.setDeliveryId(UUID.randomUUID().toString());
        deliveryOrderModel.setOrderId(orderModel.getOrderNo());
        deliveryOrderModel.setCreateTime(orderModel.getDate());
        deliveryOrderModel.setAddress("AAA");
        deliveryOrderService.createDeliveryOrder(deliveryOrderModel);
        Result result = new Result("1","11");
        //result.setCode("1");
        return result;
    }
}
