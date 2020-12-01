package com.xc.model;


public class BizParamInfo {


    Integer id;



    String paramCode;
    String paramName;
    String unit;
    String type;
    String categoryCode;

    public String getParamCode() {
        return paramCode;
    }

    public BizParamInfo setParamCode(String paramCode) {
        this.paramCode = paramCode;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public BizParamInfo setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public BizParamInfo setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getType() {
        return type;
    }

    public BizParamInfo setType(String type) {
        this.type = type;
        return this;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public BizParamInfo setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }
    public Integer getId() {
        return id;
    }

    public BizParamInfo setId(Integer id) {
        this.id = id;
        return this;
    }
    @Override
    public String toString() {
        return "BizParam{" +
                "paramCode='" + paramCode + '\'' +
                ", paramName='" + paramName + '\'' +
                ", unit='" + unit + '\'' +
                ", type='" + type + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                '}';
    }
}
