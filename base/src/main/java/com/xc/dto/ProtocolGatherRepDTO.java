package com.xc.dto;

public class ProtocolGatherRepDTO<T> {


    private String status;
    private String message;
    private T data;

    public String getStatus() {
        return status;
    }

    public ProtocolGatherRepDTO<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ProtocolGatherRepDTO<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ProtocolGatherRepDTO<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ProtocolGatherRepDTO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
