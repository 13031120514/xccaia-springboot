package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

public class RepProtocolGatherConfigItemDTO {


    private String protocolKey;

    private String protocolKeyDesc;

    private String protocolValueType;

    private String protocolValueLenth;

    public String getProtocolKey() {
        return protocolKey;
    }

    public RepProtocolGatherConfigItemDTO setProtocolKey(String protocolKey) {
        this.protocolKey = protocolKey;
        return this;
    }

    public String getProtocolKeyDesc() {
        return protocolKeyDesc;
    }

    public RepProtocolGatherConfigItemDTO setProtocolKeyDesc(String protocolKeyDesc) {
        this.protocolKeyDesc = protocolKeyDesc;
        return this;
    }

    public String getProtocolValueType() {
        return protocolValueType;
    }

    public RepProtocolGatherConfigItemDTO setProtocolValueType(String protocolValueType) {
        this.protocolValueType = protocolValueType;
        return this;
    }

    public String getProtocolValueLenth() {
        return protocolValueLenth;
    }

    public RepProtocolGatherConfigItemDTO setProtocolValueLenth(String protocolValueLenth) {
        this.protocolValueLenth = protocolValueLenth;
        return this;
    }
}
