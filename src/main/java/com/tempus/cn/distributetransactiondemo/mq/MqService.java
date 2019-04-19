package com.tempus.cn.distributetransactiondemo.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import com.tempus.cn.distributetransactiondemo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MqService {

    private final Logger logger = LoggerFactory.getLogger(MqService.class);

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    MessageService messageService;

    @PostConstruct
    public void setUp() {

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                //ack为true代表MQ准确收到消息
                if (!ack) {
                    logger.warn("MQ未能准确收到消息原因:"+cause);
                    return;
                }
                try {
                    String orderNo = correlationData.getId();
                    int count = messageService.updateMessageSendStatus(orderNo);
                    if (count == 0) {
                        logger.warn("本地信息发送状态未更新");
                    }
                } catch (Exception e) {
                    logger.error("修改本地消息时异常", e);
                }
            }
        });
    }

    public void send(OrderModel orderModel) {
        JSONObject orderInfoJson = (JSONObject) JSON.toJSON(orderModel);
        rabbitTemplate.convertAndSend("orderCreateTestExchange", "*", orderInfoJson.toJSONString(), new CorrelationData(orderInfoJson.getString("orderNo")));
    }
}
