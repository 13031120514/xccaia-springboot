package com.xc.enums;



import java.util.ArrayList;
import java.util.List;

public enum BizParamType implements IModel {

  //PRODUCTION','EXPERIMENT_CONDITION','EXPERIMENT_PROCEDURE','GROUPED','RAW_MATERIAL','CALCULATED','SYS','OTHER
  PRODUCTION("PRODUCTION", "生产"),
  EXPERIMENT("EXPERIMENT", "试验"),
  GROUPED("GROUPED", "参数组"),
  RAW_MATERIAL("RAW_MATERIAL", "原材料"),
  CALCULATED("CALCULATED", "计算"),
  SYS("SYS", "系统"),
  OTHER("OTHER", "其它");

  private final String type;
  private final String typeName;

  BizParamType(String type, String typeName) {
    this.type = type;
    this.typeName = typeName;
  }

  public static List<EnumModel> getAllTypes() {
    List<EnumModel> enumModels = new ArrayList<>();
    for (BizParamType bizParamType : BizParamType.values()) {
      enumModels.add(new EnumModel(bizParamType.getTypeName(), bizParamType.getType()));
    }
    return enumModels;
  }

  public static EnumModel getBizParamType(BizParamType bizParamType) {
    if (null != bizParamType) {
      return new EnumModel(bizParamType.getTypeName(), bizParamType.getType());
    }
    return null;
  }

  public String getType() {
    return type;
  }

  public String getTypeName() {
    return typeName;
  }

  @Override
  public String getCode() {
    return this.name();
  }

  @Override
  public String getLabel() {
    return this.typeName;
  }
}
