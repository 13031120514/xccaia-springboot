package com.sgcc.eip.cmc.cable.biz.acquisition.dto.msg;

public class ProtocolResponseDTO {

    private String status;
    private String message;
    private ProtocolGatherRepDataInfoDTO data;


    public String getStatus() {
        return status;
    }

    public ProtocolResponseDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ProtocolResponseDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public ProtocolGatherRepDataInfoDTO getData() {
        return data;
    }

    public ProtocolResponseDTO setData(ProtocolGatherRepDataInfoDTO data) {
        this.data = data;
        return this;
    }
}
