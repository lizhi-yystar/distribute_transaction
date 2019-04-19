package com.tempus.cn.distributetransactiondemo.service;

import com.tempus.cn.distributetransactiondemo.model.MessageSendModel;
import com.tempus.cn.distributetransactiondemo.model.OrderModel;

public interface MessageService {
    MessageSendModel saveMessage(OrderModel orderModel);

    int updateMessageRecord(MessageSendModel messageSendModel);

    int updateMessageSendStatus(String orderId);
}
