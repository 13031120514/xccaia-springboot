package com.xc.model;



import com.xc.enums.BizParamType;
import com.xc.enums.DataType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "cds_biz_param")
public class BizParam implements Serializable {

  private static final long serialVersionUID = -1267391751995349637L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 类别编码
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 参数编码
     */
    @Column(name = "param_code")
    private String paramCode;

    /**
     * 参数数据类型（字符，数字）
     */
    @Column(name = "param_data_type")
    private DataType paramDataType;

    /**
     * 业务参数名称
     */
    @Column(name = "param_name")
    private String paramName;

    /**
     * 业务参数描述
     */
    private String description;

    /**
     * 单位
     */
    private String unit;

    /**
     * 业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     */
    private BizParamType type;

    /**
     * 计算器编码，类型为参数组时生效
     */
    @Column(name = "calculator_code")
    private String calculatorCode;

    /**
     * 数学表达式，类型为参数组时生效
     */
    private String expression;

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

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取类别编码
     *
     * @return category_code - 类别编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置类别编码
     *
     * @param categoryCode 类别编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 获取参数编码
     *
     * @return param_code - 参数编码
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * 设置参数编码
     *
     * @param paramCode 参数编码
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    /**
     * 获取参数数据类型（字符，数字）
     *
     * @return param_data_type - 参数数据类型（字符，数字）
     */
    public DataType getParamDataType() {
        return paramDataType;
    }

    /**
     * 设置参数数据类型（字符，数字）
     *
     * @param paramDataType 参数数据类型（字符，数字）
     */
    public void setParamDataType(DataType paramDataType) {
        this.paramDataType = paramDataType;
    }

    /**
     * 获取业务参数名称
     *
     * @return param_name - 业务参数名称
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置业务参数名称
     *
     * @param paramName 业务参数名称
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * 获取业务参数描述
     *
     * @return description - 业务参数描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置业务参数描述
     *
     * @param description 业务参数描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     *
     * @return type - 业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     */
    public BizParamType getType() {
        return type;
    }

    /**
     * 设置业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     *
     * @param type 业务参数类型（生产、试验条件、试验过程、参数组、原材料、计算、系统、其他）
     */
    public void setType(BizParamType type) {
        this.type = type;
    }

    /**
     * 获取计算器编码，类型为参数组时生效
     *
     * @return calculator_code - 计算器编码，类型为参数组时生效
     */
    public String getCalculatorCode() {
        return calculatorCode;
    }

    /**
     * 设置计算器编码，类型为参数组时生效
     *
     * @param calculatorCode 计算器编码，类型为参数组时生效
     */
    public void setCalculatorCode(String calculatorCode) {
        this.calculatorCode = calculatorCode;
    }

    /**
     * 获取数学表达式，类型为参数组时生效
     *
     * @return expression - 数学表达式，类型为参数组时生效
     */
    public String getExpression() {
        return expression;
    }

    /**
     * 设置数学表达式，类型为参数组时生效
     *
     * @param expression 数学表达式，类型为参数组时生效
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void acquisitiondatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取修改时间
     *
     * @return updated_time - 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void acquisitiondatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

  @Override
  public String toString() {
    return "BizParam{" +
            "id=" + id +
            ", version=" + version +
            ", categoryCode='" + categoryCode + '\'' +
            ", paramCode='" + paramCode + '\'' +
            ", paramDataType=" + paramDataType +
            ", paramName='" + paramName + '\'' +
            ", description='" + description + '\'' +
            ", unit='" + unit + '\'' +
            ", type=" + type +
            ", calculatorCode='" + calculatorCode + '\'' +
            ", expression='" + expression + '\'' +
            ", remark='" + remark + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", createdTime=" + createdTime +
            ", updatedBy='" + updatedBy + '\'' +
            ", updatedTime=" + updatedTime +
            '}';
  }
}