package com.tempus.cn.distributetransactiondemo.util;

import com.alibaba.fastjson.JSON;
import com.tempus.cn.distributetransactiondemo.model.OrderModel;
import com.tempus.cn.distributetransactiondemo.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpClientUtils {

    public static String doPostMethod(OrderModel orderModel) throws URISyntaxException {
        String status ="false";
        //MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
        //TODO  反射实现
        //.put("")
        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(2000);
        RestTemplate template = new RestTemplate(httpRequestFactory);
        String url = "http://127.0.0.1:8081/create-delivery-service/create/test";
        ResponseEntity<Result> result = template.postForEntity(new URI(url),JSON.toJSON(orderModel),Result.class);
        if(result.getStatusCode().value()==HttpStatus.OK.value()){
            Result returnResult = result.getBody();
            if(returnResult.getCode()=="200")
                status = "true";
        }
       // ClientHttpRequest request = httpRequestFactory.createRequest(new URI("),HttpMethod.POST);
        //ClientHttpResponse response = request.execute()







        return  status;
        /* String result ="false";
       // CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/create-delivery-service/create/test");
        String entityStr = JSON.toJSONString(orderModel);
        StringEntity entity = new StringEntity(entityStr, "UTF-8");

        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        //CloseableHttpResponse response = null;
        HttpResponse response =null;
        try {
            // 由客户端执行(发送)Post请求
            response = client.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine().getStatusCode());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
            if(response.getStatusLine().getStatusCode()==HttpStatus.OK.value()){
                result = "OK";
            }
        } catch (Exception e) {
           throw e;
        } *//*finally {
            try {
                // 释放资源
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*//*
        return result;*/
    }
}
