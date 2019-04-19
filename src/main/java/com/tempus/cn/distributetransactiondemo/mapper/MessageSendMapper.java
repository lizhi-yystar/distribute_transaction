package com.tempus.cn.distributetransactiondemo.mapper;

import com.tempus.cn.distributetransactiondemo.model.MessageSendModel;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageSendMapper {

    int saveMessageInfo(MessageSendModel messageSendModel);

    int updateMessage(MessageSendModel messageSendModel);

    int updateSendStatusByOrderNo(String orderNo);
}
