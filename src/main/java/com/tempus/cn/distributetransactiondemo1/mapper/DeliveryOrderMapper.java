package com.tempus.cn.distributetransactiondemo1.mapper;

import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryOrderMapper {

    void saveDeliveryOrder(DeliveryOrderModel deliveryOrderModel);

}
