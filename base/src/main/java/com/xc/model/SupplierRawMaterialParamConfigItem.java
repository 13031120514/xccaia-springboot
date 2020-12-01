package com.xc.model;


import com.xc.enums.DataCollectMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "cds_supplier_raw_material_param_config_item")
public class SupplierRawMaterialParamConfigItem  implements Serializable {

	private static final long serialVersionUID = -4022381852957420165L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模型ID
     */
    @Column(name = "model_id")
    private Long modelId;

    /**
     * 参数编码
     */
    @Column(name = "param_code")
    private String paramCode;

    /**
     * 关键参数
     */
    private Boolean pivotal;

    /**
     * 采集模式（自动，人工）
     */
    @Column(name = "collect_mode")
    private DataCollectMode collectMode;

    /**
     * 是否必须
     */
    private Boolean required;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;
    
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

	public SupplierRawMaterialParamConfigItem(Long id, Long modelId, String paramCode, Boolean pivotal,
			DataCollectMode collectMode, Boolean required, String remark, Date createdTime, Date updatedTime,
			String createdBy, String updatedBy) {
		super();
		this.id = id;
		this.modelId = modelId;
		this.paramCode = paramCode;
		this.pivotal = pivotal;
		this.collectMode = collectMode;
		this.required = required;
		this.remark = remark;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public SupplierRawMaterialParamConfigItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public Boolean getPivotal() {
		return pivotal;
	}

	public void setPivotal(Boolean pivotal) {
		this.pivotal = pivotal;
	}

	public DataCollectMode getCollectMode() {
		return collectMode;
	}

	public void setCollectMode(DataCollectMode collectMode) {
		this.collectMode = collectMode;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
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

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
