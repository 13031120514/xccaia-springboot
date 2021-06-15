package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

import java.util.List;

public class ProtocolGatherRepInfoDTO {

  private String protocolId;
  private String protocolUrl;

  private String pushName;
  private String cycle;
  private String requestType;


  private String amount;


  public String getProtocolId() {
    return protocolId;
  }

  public ProtocolGatherRepInfoDTO setProtocolId(String protocolId) {
    this.protocolId = protocolId;
    return this;
  }

  public String getProtocolUrl() {
    return protocolUrl;
  }

  public ProtocolGatherRepInfoDTO setProtocolUrl(String protocolUrl) {
    this.protocolUrl = protocolUrl;
    return this;
  }

  public String getPushName() {
    return pushName;
  }

  public ProtocolGatherRepInfoDTO setPushName(String pushName) {
    this.pushName = pushName;
    return this;
  }

  public String getCycle() {
    return cycle;
  }

  public ProtocolGatherRepInfoDTO setCycle(String cycle) {
    this.cycle = cycle;
    return this;
  }

  public String getRequestType() {
    return requestType;
  }

  public ProtocolGatherRepInfoDTO setRequestType(String requestType) {
    this.requestType = requestType;
    return this;
  }

  public String getAmount() {
    return amount;
  }

  public ProtocolGatherRepInfoDTO setAmount(String amount) {
    this.amount = amount;
    return this;
  }
}
