package com.ljf.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author liujf05
 * @date 2019/3/12
 * 两只小象用户
 */
public class LzxxUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 两只小象Id
     */
    @Column(name = "lzxx_id")
    private Long lzxxId;

    /**
     * 两只小象的姓名
     */
    @Column(name = "lzxx_name")
    private String lzxxName;

    /**
     *两只小象轮播头像
     */
    @Column(name = "carousel_head_portrait")
    private String carouselHeadPortrait;

    /**
     *  资料完成度
     */
    @Column(name = "data_completion_percent")
    private BigDecimal dataCompletionPercent;

    /**
     *  籍贯
     */
    @Column(name = "birthplace")
    private String birthplace;

    /**
     * 生日
     */
    @Column(name = "brithday")
    private String brithday;

    /**
     *  身高
     */
    @Column(name = "height")
    private BigDecimal height;

    /**
     *  体重
     */
    @Column(name = "weight")
    private BigDecimal weight;

    /**
     *  学历
     */
    @Column(name = "educational_background")
    private String educationalBackground;

    /**
     * 企业
     */
    @Column(name = "enterprise")
    private String enterprise;

    /**
     * 职业
     */
    @Column(name = "job")
    private String job;

    /**
     * 收入
     */
    @Column(name = "income")
    private String income;

    /**
     * 常驻地址
     */
    @Column(name = "resident_address")
    private String residentAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLzxxId() {
        return lzxxId;
    }

    public void setLzxxId(Long lzxxId) {
        this.lzxxId = lzxxId;
    }

    public String getLzxxName() {
        return lzxxName;
    }

    public void setLzxxName(String lzxxName) {
        this.lzxxName = lzxxName;
    }

    public String getCarouselHeadPortrait() {
        return carouselHeadPortrait;
    }

    public void setCarouselHeadPortrait(String carouselHeadPortrait) {
        this.carouselHeadPortrait = carouselHeadPortrait;
    }

    public BigDecimal getDataCompletionPercent() {
        return dataCompletionPercent;
    }

    public void setDataCompletionPercent(BigDecimal dataCompletionPercent) {
        this.dataCompletionPercent = dataCompletionPercent;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }
}
