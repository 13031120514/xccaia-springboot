package com.xc.enums;


import java.io.Serializable;

/**
 * @author Aadi.Liu
 * @date 2020/3/9 18:09
 * @Description
 */
public class EnumModel implements Serializable {

  private static final long serialVersionUID = -6805864847965616641L;
  private String label;
  private String value;

  public EnumModel() {
  }

  public EnumModel(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public EnumModel setLabel(String label) {
    this.label = label;
    return this;
  }

  public String getValue() {
    return value;
  }

  public EnumModel setValue(String value) {
    this.value = value;
    return this;
  }
}
