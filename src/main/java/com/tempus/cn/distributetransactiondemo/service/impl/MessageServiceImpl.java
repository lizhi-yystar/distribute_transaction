package com.tempus.cn.distributetransactiondemo.service.impl;

import com.tempus.cn.distributetransactiondemo.mapper.MessageSendMapper;
import com.tempus.cn.distributetransactiondemo.model.MessageSendModel;
import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import com.tempus.cn.distributetransactiondemo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    MessageSendMapper messageSendMapper;

    @Override
    public MessageSendModel saveMessage(OrderModel orderModel) {
        MessageSendModel messageSendModel = new MessageSendModel();
        messageSendModel.setCreateTime(orderModel.getDate());
        messageSendModel.setOrderId(orderModel.getOrderNo());
        messageSendModel.setMessageStatus("0");//0 -未发送状态
        logger.info("保存本地信息表:"+messageSendModel.toString());
        messageSendMapper.saveMessageInfo(messageSendModel);
        return messageSendModel;
    }

    @Override
    public int updateMessageRecord(MessageSendModel messageSendModel) {
       return messageSendMapper.updateMessage(messageSendModel);
    }

    @Override
    public int updateMessageSendStatus(String orderId) {
        return messageSendMapper.updateSendStatusByOrderNo(orderId);
    }
}
