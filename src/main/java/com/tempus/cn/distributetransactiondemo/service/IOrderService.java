package com.tempus.cn.distributetransactiondemo.service;

import com.tempus.cn.distributetransactiondemo.model.OrderModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IOrderService {
    void createOrder(OrderModel orderModel) throws IOException, URISyntaxException;
}
