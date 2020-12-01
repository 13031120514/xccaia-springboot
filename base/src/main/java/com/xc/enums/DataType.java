package com.xc.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aadi.Liu
 * @date 2020/2/20 15:44
 * @Description
 */
public enum DataType implements IModel {
  STRING("STRING", "字符"),
  NUMBER("NUMBER", "数字"),

  //数据类型与文件类型需要分开 姚涛 20200729
//  IMAGE("IMAGE", "图片"),
//  FILE("FILE", "文件"),
  ;

  private final String type;
  private final String typeName;

  public static List<EnumModel> getAllTypes() {
    List<EnumModel> enumModels = new ArrayList<>();
    for (DataType dataType : DataType.values()) {
      enumModels.add(new EnumModel(dataType.getTypeName(), dataType.getType()));
    }
    return enumModels;
  }

  DataType(String type, String typeName) {
    this.type = type;
    this.typeName = typeName;
  }

  public static EnumModel getDataType(DataType dataType) {
    if (dataType != null) {
      return new EnumModel(dataType.getTypeName(), dataType.getType());
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
