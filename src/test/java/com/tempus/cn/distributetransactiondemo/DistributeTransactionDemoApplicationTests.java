package com.tempus.cn.distributetransactiondemo;

import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import com.tempus.cn.distributetransactiondemo.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DistributeTransactionDemoApplication.class)
public class DistributeTransactionDemoApplicationTests {

    @Resource
    @Qualifier("test")
    IOrderService orderService;

    @Test
    public void contextLoads() throws IOException, URISyntaxException {
        OrderModel orderModel = new OrderModel();
        orderModel.setDate(new Date());
        orderModel.setOrderNo("10002");
        orderModel.setUserName("569874");
        orderService.createOrder(orderModel);

    }

}
