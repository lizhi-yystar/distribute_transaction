package com.tempus.cn.distributetransactiondemo1;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import com.tempus.cn.distributetransactiondemo1.util.HttpResponseHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetSocketAddress;

@SpringBootApplication
@MapperScan(basePackages = {"com.tempus.cn.distributetransactiondemo1.mapper"})
public class DistributeTransactionDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(DistributeTransactionDemo1Application.class, args);
     /*   HttpServerProvider provider = HttpServerProvider.provider();
        HttpServer httpserver = null;//监听端口19017,能同时接受100个请求
        try {
            httpserver = provider.createHttpServer(new InetSocketAddress(8081), 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpserver.createContext("/", new HttpResponseHandler());
        httpserver.setExecutor(null);
        httpserver.start();*/
    }

}
