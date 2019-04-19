package com.tempus.cn.distributetransactiondemo1.util;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.tempus.cn.distributetransactiondemo1.model.DeliveryOrderModel;
import com.tempus.cn.distributetransactiondemo1.service.IDeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;

@Component
public class HttpResponseHandler implements HttpHandler {

    @Autowired
    IDeliveryOrderService deliveryOrderService;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("receive");
        String requestMethod = httpExchange.getRequestMethod();
        if(requestMethod.equalsIgnoreCase("POST")){//客户端的请求是get方法
            //设置服务端响应的编码格式，否则在客户端收到的可能是乱码
            Headers responseHeaders = httpExchange.getResponseHeaders();
            responseHeaders.set("Content-Type", "text/html;charset=utf-8");
            //在这里通过httpExchange获取客户端发送过来的消息
            //URI url = httpExchange.getRequestURI();
            InputStream requestBody = httpExchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "/n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sb.toString());
            deliveryOrderService.createDeliveryOrder(new DeliveryOrderModel());
            String response = "this is server";
            httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes("UTF-8").length);
            OutputStream responseBody = httpExchange.getResponseBody();
            OutputStreamWriter writer = new OutputStreamWriter(responseBody, "UTF-8");
            writer.write(response);
            writer.close();
            responseBody.close();
        }
    }
}
