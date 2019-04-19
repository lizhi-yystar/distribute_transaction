package com.tempus.cn.distributetransactiondemo1.model;

import java.io.Serializable;
import java.util.Date;

public class OrderModel implements Serializable {

    private static final long serialVersionUID = 184642236916456391L;
    private Integer id;
    private String orderNo;
    private String userName;
    private Date date;

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
