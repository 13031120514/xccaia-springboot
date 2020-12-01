package com.xc.model;


import com.xc.enums.BizParamType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "cds_supplier_protocol_gather_config")
public class SupplierProtocolGatherConfig implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 版本号
     */
    private Integer version;

    @Column(name = "source_config_model_id")
    private Long sourceConfigModelId;

    /**
     * 供应商编码
     */
    @Column(name = "supplier_code")
    private String supplierCode;
    /**
     * 类别编码
     */
    @Column(name = "category_code")
    private String categoryCode;
    /**
     * 采集协议id
     */
    @Column(name = "protocol_id")
    private String protocolId;
    /**
     * 采集协议名称
     */
    @Column(name = "protocol_name")
    private String protocolName;

    /**
     * 推送协议id
     */
    @Column(name = "protocol_push_id")
    private String protocolPushId;
    /**
     * 协议业务表注释
     */
    @Column(name = "business_table_name")
    private String businessTableName;
    /**
     * 协议业务表名
     */
    @Column(name = "business_table")
    private String businessTable;

    /**
     * 供应商侧接口地址
     */
    @Column(name = "protocol_url")
    private String protocolUrl;
    /**
     * 采集周期，cron 表达式
     */
    private String cycle;
    /**
     * 请求方式post get
     */
    @Column(name = "request_type")
    private String requestType;
    /**
     * 采集数据量限制
     */
    private String amount;
    /**
     * 协议类型：1-采集，3-推送
     */
    @Column(name = "protocol_type")
    private String protocolType;
    /**
     * 协议状态：2-启用，3-禁用
     */
    @Column(name = "protocol_state")
    private String protocolState;
    /**
     * 信息编码
     */
    @Column(name = "info_code")
    private String infoCode;
    /**
     * 业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     */
    private BizParamType type;

    /**
     * 供应商编码
     */
    private String remark;

    /**
     * 创建人
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 创建时间
     */
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

    public SupplierProtocolGatherConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public SupplierProtocolGatherConfig setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public Long getSourceConfigModelId() {
        return sourceConfigModelId;
    }

    public SupplierProtocolGatherConfig setSourceConfigModelId(Long sourceConfigModelId) {
        this.sourceConfigModelId = sourceConfigModelId;
        return this;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public SupplierProtocolGatherConfig setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public SupplierProtocolGatherConfig setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public String getProtocolId() {
        return protocolId;
    }

    public SupplierProtocolGatherConfig setProtocolId(String protocolId) {
        this.protocolId = protocolId;
        return this;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public SupplierProtocolGatherConfig setProtocolName(String protocolName) {
        this.protocolName = protocolName;
        return this;
    }

    public String getProtocolPushId() {
        return protocolPushId;
    }

    public SupplierProtocolGatherConfig setProtocolPushId(String protocolPushId) {
        this.protocolPushId = protocolPushId;
        return this;
    }

    public String getBusinessTableName() {
        return businessTableName;
    }

    public SupplierProtocolGatherConfig setBusinessTableName(String businessTableName) {
        this.businessTableName = businessTableName;
        return this;
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public SupplierProtocolGatherConfig setBusinessTable(String businessTable) {
        this.businessTable = businessTable;
        return this;
    }

    public String getProtocolUrl() {
        return protocolUrl;
    }

    public SupplierProtocolGatherConfig setProtocolUrl(String protocolUrl) {
        this.protocolUrl = protocolUrl;
        return this;
    }

    public String getCycle() {
        return cycle;
    }

    public SupplierProtocolGatherConfig setCycle(String cycle) {
        this.cycle = cycle;
        return this;
    }

    public String getRequestType() {
        return requestType;
    }

    public SupplierProtocolGatherConfig setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public SupplierProtocolGatherConfig setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public SupplierProtocolGatherConfig setProtocolType(String protocolType) {
        this.protocolType = protocolType;
        return this;
    }

    public String getProtocolState() {
        return protocolState;
    }

    public SupplierProtocolGatherConfig setProtocolState(String protocolState) {
        this.protocolState = protocolState;
        return this;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public SupplierProtocolGatherConfig setInfoCode(String infoCode) {
        this.infoCode = infoCode;
        return this;
    }

    public BizParamType getType() {
        return type;
    }

    public SupplierProtocolGatherConfig setType(BizParamType type) {
        this.type = type;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public SupplierProtocolGatherConfig setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SupplierProtocolGatherConfig setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public SupplierProtocolGatherConfig setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public SupplierProtocolGatherConfig setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public SupplierProtocolGatherConfig setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    @Override
    public String toString() {
        return "SupplierProtocolGatherConfig{" +
                "id=" + id +
                ", version=" + version +
                ", sourceConfigModelId=" + sourceConfigModelId +
                ", supplierCode='" + supplierCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", protocolId='" + protocolId + '\'' +
                ", protocolName='" + protocolName + '\'' +
                ", protocolPushId='" + protocolPushId + '\'' +
                ", businessTableName='" + businessTableName + '\'' +
                ", businessTable='" + businessTable + '\'' +
                ", protocolUrl='" + protocolUrl + '\'' +
                ", cycle='" + cycle + '\'' +
                ", requestType='" + requestType + '\'' +
                ", amount='" + amount + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", protocolState='" + protocolState + '\'' +
                ", infoCode='" + infoCode + '\'' +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
