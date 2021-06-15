package com.xc.dto;

public class ProtocolGatherRepDTO1<T> {


  private String status;
  private String message;
  private T data;

  public String getStatus() {
    return status;
  }

  public ProtocolGatherRepDTO1<T> setStatus(String status) {
    this.status = status;
    return this;
  }
}
