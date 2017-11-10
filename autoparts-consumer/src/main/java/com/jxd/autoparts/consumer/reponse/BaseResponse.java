package com.jxd.autoparts.consumer.reponse;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    protected String serialNumber;//流水号
    protected Integer result;      //返回结果
    protected String message;     //结果说明
    protected Object body;        //具体返回内容

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "serialNumber='" + serialNumber + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
