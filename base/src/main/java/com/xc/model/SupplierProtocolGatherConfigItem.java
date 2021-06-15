package com.xc.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "cds_supplier_protocol_gather_config_item")
public class SupplierProtocolGatherConfigItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 模型ID
   */
  @Column(name = "model_id")
  private Long modelId;

  /**
   * 采集协议id
   */
  @Column(name = "protocol_id")
  private String protocolId;

  /**
   * 协议字段key名称（供应商侧参数名称）
   */
  @Column(name = "protocol_key")
  private String protocolKey;

  /**
   * 字段中文描述
   */
  @Column(name = "protocol_key_desc")
  private String protocolKeyDesc;

  /**
   * 协议字段值类型0-string,1-int,2-long,3-datetime,4-boolean,5-float,6-file
   */
  @Column(name = "protocol_value_type")
  private String protocolValueType;

  /**
   * 字段长度限制
   */
  @Column(name = "protocol_value_length")
  private String protocolValueLength;

  /**
   * 逻辑删除 1.是，0.否
   */
  private String deleted;

  /**
   * 是否为空  0-允许为空（默认） 1-禁止为空
   */
  @Column(name = "null_able")
  private Boolean nullAble;

  private String remark;

  @Column(name = "created_time")
  private Date createdTime;

  @Column(name = "created_by")
  private String createdBy;

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

  public Long getId() {
    return id;
  }

  public SupplierProtocolGatherConfigItem setId(Long id) {
    this.id = id;
    return this;
  }

  public String getProtocolId() {
    return protocolId;
  }

  public SupplierProtocolGatherConfigItem setProtocolId(String protocolId) {
    this.protocolId = protocolId;
    return this;
  }

  public String getProtocolKey() {
    return protocolKey;
  }

  public SupplierProtocolGatherConfigItem setProtocolKey(String protocolKey) {
    this.protocolKey = protocolKey;
    return this;
  }

  public String getProtocolKeyDesc() {
    return protocolKeyDesc;
  }

  public SupplierProtocolGatherConfigItem setProtocolKeyDesc(String protocolKeyDesc) {
    this.protocolKeyDesc = protocolKeyDesc;
    return this;
  }

  public String getProtocolValueType() {
    return protocolValueType;
  }

  public SupplierProtocolGatherConfigItem setProtocolValueType(String protocolValueType) {
    this.protocolValueType = protocolValueType;
    return this;
  }

  public String getProtocolValueLength() {
    return protocolValueLength;
  }

  public SupplierProtocolGatherConfigItem setProtocolValueLength(String protocolValueLength) {
    this.protocolValueLength = protocolValueLength;
    return this;
  }

  public String getDeleted() {
    return deleted;
  }

  public SupplierProtocolGatherConfigItem setDeleted(String deleted) {
    this.deleted = deleted;
    return this;
  }

  public String getRemark() {
    return remark;
  }

  public SupplierProtocolGatherConfigItem setRemark(String remark) {
    this.remark = remark;
    return this;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public SupplierProtocolGatherConfigItem setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public SupplierProtocolGatherConfigItem setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public SupplierProtocolGatherConfigItem setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public SupplierProtocolGatherConfigItem setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }


  public Long getModelId() {
    return modelId;
  }

  public SupplierProtocolGatherConfigItem setModelId(Long modelId) {
    this.modelId = modelId;
    return this;
  }

  public Boolean getNullAble() {
    return nullAble;
  }

  public SupplierProtocolGatherConfigItem setNullAble(Boolean nullAble) {
    this.nullAble = nullAble;
    return this;
  }
}