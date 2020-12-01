package com.xc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 返回供应商评价任务信息_数据上传及时性问题分析
 *
 * @Author: xiaochuan.cai
 * @Date: 2020/11/3
 */
@Table(name = "cds_supplier_information_timely")
public class SupplierInformationTimely implements Serializable {
    private static final long serialVersionUID = 326846703314654163L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 评价任务编码
     */
    private String taskEvaluNum;

    /**
     * 返回供应商评价任务信息ID
     */
    private Long evaluationInformationId;

    /**
     * 上报数据及时率评价信息项数量
     */
    private String timelinessRateNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskEvaluNum() {
        return taskEvaluNum;
    }

    public void setTaskEvaluNum(String taskEvaluNum) {
        this.taskEvaluNum = taskEvaluNum == null ? null : taskEvaluNum.trim();
    }

    public Long getEvaluationInformationId() {
        return evaluationInformationId;
    }

    public void setEvaluationInformationId(Long evaluationInformationId) {
        this.evaluationInformationId = evaluationInformationId;
    }

    public String getTimelinessRateNum() {
        return timelinessRateNum;
    }

    public void setTimelinessRateNum(String timelinessRateNum) {
        this.timelinessRateNum = timelinessRateNum == null ? null : timelinessRateNum.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "SupplierInformationTimely{" +
                "id=" + id +
                ", taskEvaluNum='" + taskEvaluNum + '\'' +
                ", evaluationInformationId=" + evaluationInformationId +
                ", timelinessRateNum='" + timelinessRateNum + '\'' +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}