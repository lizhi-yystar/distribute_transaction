package com.tempus.cn.distributetransactiondemo.model;

import java.io.Serializable;
import java.util.Date;

public class MessageSendModel implements Serializable {

    private static final long serialVersionUID = -6209447451048278170L;
    private Integer id;

    private String orderId;

    private String messageStatus;

    private String errorInfo;

    private Date createTime;

    @Override
    public String toString() {
        return "MessageSendModel{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", messageStatus='" + messageStatus + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
