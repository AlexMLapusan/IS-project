package com.spring.utils;

public class ResponseHandler {
    private String status;
    private Object data;

    public ResponseHandler(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}
