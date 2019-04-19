package com.tempus.cn.distributetransactiondemo.service.impl;

import com.tempus.cn.distributetransactiondemo.mapper.MessageSendMapper;
import com.tempus.cn.distributetransactiondemo.mapper.OrderMapper;
import com.tempus.cn.distributetransactiondemo.model.MessageSendModel;
import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import com.tempus.cn.distributetransactiondemo.mq.MqService;
import com.tempus.cn.distributetransactiondemo.service.IOrderService;
import com.tempus.cn.distributetransactiondemo.service.MessageService;
import com.tempus.cn.distributetransactiondemo.util.HttpClientUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
@Qualifier("test")
public class OrderServiceImpl implements IOrderService {

    @Resource
    OrderMapper orderMapper;
    @Autowired
    MessageService messageService;
    @Autowired
    MqService mqService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(OrderModel orderModel) throws URISyntaxException {
        //创建订单
        orderMapper.createOrder(orderModel);
        //System.out.println(1/0);
        messageService.saveMessage(orderModel);
        //保存发送记录
        mqService.send(orderModel);




        /* String response = callCreateDeliveryOrderByHttp(orderModel);
        if(!"OK".equals(response)){
            System.out.println("创建订单失败");
        }*/
    }

   /* public String callCreateDeliveryOrderByHttp(OrderModel orderModel) throws URISyntaxException {
        return HttpClientUtils.doPostMethod(orderModel);
    }*/
}
