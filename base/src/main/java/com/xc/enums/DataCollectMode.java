package com.xc.enums;

import org.apache.commons.lang3.StringUtils;

public enum DataCollectMode implements IModel {

  AUTO("AUTO", "自动采集"), MANUAL("MANUAL", "系统推送");

  private final String type;
  private final String typeName;

  DataCollectMode(String type, String typeName) {
    this.type = type;
    this.typeName = typeName;
  }

  public static DataCollectMode is(String target) {
    for (DataCollectMode dataCollectMode : DataCollectMode.values()) {
      if (StringUtils.equals(target, dataCollectMode.name())) {
        return dataCollectMode;
      }
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
    return this.type;
  }

  @Override
  public String getLabel() {
    return this.typeName;
  }
}
