package com.tempus.cn.distributetransactiondemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tempus.cn.distributetransactiondemo.mapper"})
public class DistributeTransactionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionDemoApplication.class, args);
    }

}
