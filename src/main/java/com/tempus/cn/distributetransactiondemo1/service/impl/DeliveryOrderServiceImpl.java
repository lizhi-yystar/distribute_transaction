package com.tempus.cn.distributetransactiondemo1.service.impl;

import com.tempus.cn.distributetransactiondemo1.mapper.DeliveryOrderMapper;
import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import com.tempus.cn.distributetransactiondemo1.service.IDeliveryOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DeliveryOrderServiceImpl implements IDeliveryOrderService {

    private final Logger logger = LoggerFactory.getLogger(DeliveryOrderServiceImpl.class);

    @Autowired
    DeliveryOrderMapper deliveryOrderMapper;

    @Override
    public void createDeliveryOrder(DeliveryOrderModel deliveryOrderModel) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("保存配送订单:"+deliveryOrderModel.toString());
        deliveryOrderMapper.saveDeliveryOrder(deliveryOrderModel);
    }
}
