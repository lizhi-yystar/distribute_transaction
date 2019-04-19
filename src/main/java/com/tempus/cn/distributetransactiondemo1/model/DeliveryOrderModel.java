package com.tempus.cn.distributetransactiondemo1.model;

import java.io.Serializable;
import java.util.Date;

public class DeliveryOrderModel implements Serializable {

    private static final long serialVersionUID = -5980263571851022017L;
    private Integer id;

    private String deliveryId;

    private String orderId;

    private String address;

    private Date createTime;

    @Override
    public String toString() {
        return "DeliveryOrderModel{" +
                "id=" + id +
                ", deliveryId='" + deliveryId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
