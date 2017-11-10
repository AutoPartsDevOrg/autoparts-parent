package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.MerchantInfoEntity;

import java.util.Date;

public class MerchantInfoPj extends BasePj {

    private Long id;
    private String merchantCode;
    private String merchantName;
    private String merchantType;
    private Integer status;
    private String enterpriseType;
    private String enterpriseProperty;
    private String businessLicense;
    private String identityFront;
    private String identityBack;
    private String province;
    private String city;
    private String county;
    private String address;
    private String enterpriseLevel;
    private Date createTime;
    private Date updateTime;
    private MerSimAccountPj createUser;
    private MerSimAccountPj updateUser;

    public MerchantInfoPj() {
    }

    public MerchantInfoPj(MerchantInfoEntity ety) {
        copy(this,ety);
        if(ety!=null && ety.getMerAccountByCreateUid()!=null){
            this.createUser = new MerSimAccountPj(ety.getMerAccountByCreateUid());
        }
        if(ety!=null && ety.getMerAccountByUpdateUid()!=null){
            this.updateUser = new MerSimAccountPj(ety.getMerAccountByUpdateUid());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getIdentityFront() {
        return identityFront;
    }

    public void setIdentityFront(String identityFront) {
        this.identityFront = identityFront;
    }

    public String getIdentityBack() {
        return identityBack;
    }

    public void setIdentityBack(String identityBack) {
        this.identityBack = identityBack;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnterpriseLevel() {
        return enterpriseLevel;
    }

    public void setEnterpriseLevel(String enterpriseLevel) {
        this.enterpriseLevel = enterpriseLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public MerSimAccountPj getCreateUser() {
        return createUser;
    }

    public void setCreateUser(MerSimAccountPj createUser) {
        this.createUser = createUser;
    }

    public MerSimAccountPj getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(MerSimAccountPj updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "MerchantInfoPj{" +
                "id=" + id +
                ", merchantCode='" + merchantCode + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", merchantType='" + merchantType + '\'' +
                ", status=" + status +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", enterpriseProperty='" + enterpriseProperty + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", identityFront='" + identityFront + '\'' +
                ", identityBack='" + identityBack + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address='" + address + '\'' +
                ", enterpriseLevel='" + enterpriseLevel + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                '}';
    }
}
