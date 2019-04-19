package com.tempus.cn.distributetransactiondemo.mapper;

import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    int createOrder(OrderModel orderModel);

}
