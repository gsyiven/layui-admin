package org.alex.admin.web.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author Song Guo
 * @since 2020.9.11
 */
@TableName("sys_product")
public class SysProduct extends Model<SysProduct> {

//    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type=IdType.AUTO)
    private long id;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 检测地点
     */
    private String detectionLocation;
    /**
     * 检测日期
     */
    private String detectionDate;
    /**
     * 检测结果
     */
    private String detectionResult;
    /**
     * 一级分类
     */
    private String firstClass;
    /**
     * 二级分类
     */
    private String secondClass;
    /**
     * 三级分类
     */
    private String thirdClass;
    /**
     * 四级分类
     */
    private String fourthClass;
    /**
     * 受检企业名称
     */
    private String company;
    /**
     * 标称生产企业名称
     */
    private String manufacturer;
    /**
     * 商标
     */
    private String brand;
    /**
     * 规格型号
     */
    private String spec;
    /**
     * 生产日期/批号
     */
    private String productionDate;
    /**
     * 承检机构
     */
    private String inspectionAgency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetectionLocation() {
        return detectionLocation;
    }

    public void setDetectionLocation(String detectionLocation) {
        this.detectionLocation = detectionLocation;
    }

    public String getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(String detectionDate) {
        this.detectionDate = detectionDate;
    }

    public String getDetectionResult() {
        return detectionResult;
    }

    public void setDetectionResult(String detectionResult) {
        this.detectionResult = detectionResult;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public String getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(String thirdClass) {
        this.thirdClass = thirdClass;
    }

    public String getFourthClass() {
        return fourthClass;
    }

    public void setFourthClass(String fourthClass) {
        this.fourthClass = fourthClass;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getInspectionAgency() {
        return inspectionAgency;
    }

    public void setInspectionAgency(String inspectionAgency) {
        this.inspectionAgency = inspectionAgency;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
