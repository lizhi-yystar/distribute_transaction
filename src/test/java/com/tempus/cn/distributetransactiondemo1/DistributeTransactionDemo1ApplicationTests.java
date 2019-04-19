package com.tempus.cn.distributetransactiondemo1;

import com.tempus.cn.distributetransactiondemo1.mapper.DeliveryOrderMapper;
import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import com.tempus.cn.distributetransactiondemo1.service.IDeliveryOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DistributeTransactionDemo1Application.class)
public class DistributeTransactionDemo1ApplicationTests {

    @Autowired
    IDeliveryOrderService deliveryOrderService;

    @Test
    public void contextLoads() {
        DeliveryOrderModel deliveryOrderModel = new DeliveryOrderModel();
        deliveryOrderModel.setAddress("腾邦国际");
        deliveryOrderModel.setCreateTime(new Date());
        deliveryOrderModel.setDeliveryId(UUID.randomUUID().toString());
        deliveryOrderModel.setOrderId("10001");
        deliveryOrderService.createDeliveryOrder(deliveryOrderModel);
    }

}
