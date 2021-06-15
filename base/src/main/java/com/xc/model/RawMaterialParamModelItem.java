package com.xc.model;


import com.xc.enums.DataCollectMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "cds_raw_material_param_model_item")
public class RawMaterialParamModelItem implements Serializable {

  private static final long serialVersionUID = -973555347005436702L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 模板ID
   */
  @Column(name = "model_id")
  private Long modelId;

  /**
   * 参数编码
   */
  @Column(name = "param_code")
  private String paramCode;

  /**
   * 是否必须
   */
  private Boolean required;
  /**
   * 采集模式（自动，人工）
   */
  @Column(name = "collect_mode")
  private DataCollectMode collectMode;

  /**
   * 关键参数
   */
  private Boolean pivotal;

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

  public RawMaterialParamModelItem setId(Long id) {
    this.id = id;
    return this;
  }

  public Long getModelId() {
    return modelId;
  }

  public RawMaterialParamModelItem setModelId(Long modelId) {
    this.modelId = modelId;
    return this;
  }

  public String getParamCode() {
    return paramCode;
  }

  public RawMaterialParamModelItem setParamCode(String paramCode) {
    this.paramCode = paramCode;
    return this;
  }

  public Boolean getRequired() {
    return required;
  }

  public RawMaterialParamModelItem setRequired(Boolean required) {
    this.required = required;
    return this;
  }

  public DataCollectMode getCollectMode() {
    return collectMode;
  }

  public RawMaterialParamModelItem setCollectMode(DataCollectMode collectMode) {
    this.collectMode = collectMode;
    return this;
  }

  public Boolean getPivotal() {
    return pivotal;
  }

  public RawMaterialParamModelItem setPivotal(Boolean pivotal) {
    this.pivotal = pivotal;
    return this;
  }

  public String getRemark() {
    return remark;
  }

  public RawMaterialParamModelItem setRemark(String remark) {
    this.remark = remark;
    return this;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public RawMaterialParamModelItem setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public RawMaterialParamModelItem setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public RawMaterialParamModelItem setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public RawMaterialParamModelItem setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  @Override
  public String toString() {
    return "RawMaterialParamModelItem{" +
        "id=" + id +
        ", modelId=" + modelId +
        ", paramCode='" + paramCode + '\'' +
        ", required=" + required +
        ", collectMode='" + collectMode + '\'' +
        ", pivotal=" + pivotal +
        ", remark='" + remark + '\'' +
        ", createdBy='" + createdBy + '\'' +
        ", createdTime=" + createdTime +
        ", updatedBy='" + updatedBy + '\'' +
        ", updatedTime=" + updatedTime +
        '}';
  }
}