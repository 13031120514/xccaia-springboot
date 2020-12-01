package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

import java.util.List;

public class ProtocolGatherRepDataInfoDTO {

    private ProtocolGatherRepInfoDTO info;


    private String businessTableName;


    private List<RepProtocolGatherConfigItemDTO> protocolFieldList;


    public ProtocolGatherRepInfoDTO getInfo() {
        return info;
    }

    public ProtocolGatherRepDataInfoDTO setInfo(ProtocolGatherRepInfoDTO info) {
        this.info = info;
        return this;
    }

    public String getBusinessTableName() {
        return businessTableName;
    }

    public ProtocolGatherRepDataInfoDTO setBusinessTableName(String businessTableName) {
        this.businessTableName = businessTableName;
        return this;
    }

    public List<RepProtocolGatherConfigItemDTO> getProtocolFieldList() {
        return protocolFieldList;
    }

    public ProtocolGatherRepDataInfoDTO setProtocolFieldList(List<RepProtocolGatherConfigItemDTO> protocolFieldList) {
        this.protocolFieldList = protocolFieldList;
        return this;
    }
}
