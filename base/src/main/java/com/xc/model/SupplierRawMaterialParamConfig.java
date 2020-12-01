package com.xc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "cds_supplier_raw_material_param_config")
public class SupplierRawMaterialParamConfig  implements Serializable {

	private static final long serialVersionUID = 4222191010592097778L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "supplier_code")
    private String supplierCode;

    private Integer version;
    
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
    
    @Column(name = "param_number")
    private Integer paramNumber;

    private String remark;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;

    private Byte deleted;

	public SupplierRawMaterialParamConfig() {
		super();
	}

	public SupplierRawMaterialParamConfig(Long id, String supplierCode, Integer version, String categoryCode,
			String infoCode, String infoName, Integer paramNumber, String remark, Date createdTime, String createdBy,
			Date updatedTime, String updatedBy, Byte deleted) {
		super();
		this.id = id;
		this.supplierCode = supplierCode;
		this.version = version;
		this.categoryCode = categoryCode;
		this.infoCode = infoCode;
		this.infoName = infoName;
		this.paramNumber = paramNumber;
		this.remark = remark;
		this.createdTime = createdTime;
		this.createdBy = createdBy;
		this.updatedTime = updatedTime;
		this.updatedBy = updatedBy;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public Integer getParamNumber() {
		return paramNumber;
	}

	public void setParamNumber(Integer paramNumber) {
		this.paramNumber = paramNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Byte getDeleted() {
		return deleted;
	}

	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}
}