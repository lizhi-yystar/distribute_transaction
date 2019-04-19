package com.tempus.cn.distributetransactiondemo1.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import com.tempus.cn.distributetransactiondemo1.service.IDeliveryOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
/*@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "orderCreateTestQue", durable = "true"),
        exchange = @Exchange(value = "orderCreateTestExchange", type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true", durable = "true"),
        key = "*"))*/
public class DeliveryOrderConSumer {

    private static Logger logger = LoggerFactory.getLogger(DeliveryOrderConSumer.class);

    @Autowired
    IDeliveryOrderService deliveryOrderService;

    @RabbitListener(queues = "orderCreateTestQue")
    public void messageConSumser(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG)long tag) throws IOException {
            try{
                logger.info("收到的mq消息信息："+message);
                //幂等性 --redis  数据库等去重机制
                JSONObject orderInfo = (JSONObject) JSONObject.parse(message);
                DeliveryOrderModel deliveryOrderModel = new DeliveryOrderModel();
                deliveryOrderModel.setOrderId(orderInfo.getString("orderNo"));
                deliveryOrderModel.setCreateTime(orderInfo.getDate("date"));
                deliveryOrderModel.setDeliveryId(UUID.randomUUID().toString());
                deliveryOrderService.createDeliveryOrder(deliveryOrderModel);
                //通知mq消息已经收到
                channel.basicAck(tag,false);
            }catch (Exception e){
                logger.error("",e);
                //异常情况  根据需要去重发  丢弃
                channel.basicNack(tag,false,false);
                //线上告警
            }

    }
}
