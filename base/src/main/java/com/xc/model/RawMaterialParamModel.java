package com.xc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "cds_raw_material_param_model")
public class RawMaterialParamModel implements Serializable {

  private static final long serialVersionUID = 2081947756158715188L;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 版本号
   */
  private Integer version;

  /**
   * 品类编码
   */
  @Column(name = "category_code")
  private String categoryCode;

  /**
   * 信息编码
   */
  @Column(name = "info_code")
  private String infoCode;

  /**
   * 信息名称
   */
  @Column(name = "info_name")
  private String infoName;

  /**
   * 数据项数量
   */
  @Column(name = "param_number")
  private Integer paramNumber;

  /**
   * 备注
   */
  private String remark;

  /**
   * 创建人
   */
  @Column(name = "created_by")
  private String createdBy;

  /**
   * 创建时间
   */
  @Column(name = "created_time")
  private Date createdTime;

  /**
   * 修改人
   */
  @Column(name = "updated_by")
  private String updatedBy;

  /**
   * 修改时间
   */
  @Column(name = "updated_time")
  private Date updatedTime;


  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public RawMaterialParamModel setId(Long id) {
    this.id = id;
    return this;
  }

  public Integer getVersion() {
    return version;
  }

  public RawMaterialParamModel setVersion(Integer version) {
    this.version = version;
    return this;
  }

  public String getCategoryCode() {
    return categoryCode;
  }

  public RawMaterialParamModel setCategoryCode(String categoryCode) {
    this.categoryCode = categoryCode;
    return this;
  }

  public String getInfoCode() {
    return infoCode;
  }

  public RawMaterialParamModel setInfoCode(String infoCode) {
    this.infoCode = infoCode;
    return this;
  }

  public String getInfoName() {
    return infoName;
  }

  public RawMaterialParamModel setInfoName(String infoName) {
    this.infoName = infoName;
    return this;
  }

  public Integer getParamNumber() {
    return paramNumber;
  }

  public RawMaterialParamModel setParamNumber(Integer paramNumber) {
    this.paramNumber = paramNumber;
    return this;
  }

  public String getRemark() {
    return remark;
  }

  public RawMaterialParamModel setRemark(String remark) {
    this.remark = remark;
    return this;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public RawMaterialParamModel setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public RawMaterialParamModel setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public RawMaterialParamModel setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public RawMaterialParamModel setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  @Override
  public String toString() {
    return "RawMaterialParamModel{" +
            "id=" + id +
            ", version=" + version +
            ", categoryCode='" + categoryCode + '\'' +
            ", infoCode='" + infoCode + '\'' +
            ", infoName='" + infoName + '\'' +
            ", paramNumber=" + paramNumber +
            ", remark='" + remark + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdTime=" + createdTime +
            ", updatedBy='" + updatedBy + '\'' +
            ", updatedTime=" + updatedTime +
            '}';
  }
}