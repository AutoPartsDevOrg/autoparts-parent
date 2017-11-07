package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "merchant_info", schema = "autoparts", catalog = "")
public class MerchantInfoEntity extends IdEntity {

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
    private int version;
    private Long createUid;
    private Long updateUid;

    private Collection<MerAccountEntity> merAccountsById;
    private Collection<MerchantBrandRelEntity> merchantBrandRelsById;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByUpdateUid;
    private Collection<MerchantModelsRelEntity> merchantModelsRelsById;
    private Collection<MerchantScopeRelEntity> merchantScopeRelsById;
    private Collection<ReceiveDeliveryAddressEntity> receiveDeliveryAddressesById;


    @Basic
    @Column(name = "merchant_code", nullable = true, length = 50)
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @Basic
    @Column(name = "merchant_name", nullable = true, length = 50)
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Basic
    @Column(name = "merchant_type", nullable = true, length = 10)
    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "enterprise_type", nullable = true, length = 20)
    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    @Basic
    @Column(name = "enterprise_property", nullable = true, length = 20)
    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty;
    }

    @Basic
    @Column(name = "business_license", nullable = true, length = 100)
    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    @Basic
    @Column(name = "identity_front", nullable = true, length = 100)
    public String getIdentityFront() {
        return identityFront;
    }

    public void setIdentityFront(String identityFront) {
        this.identityFront = identityFront;
    }

    @Basic
    @Column(name = "identity_back", nullable = true, length = 100)
    public String getIdentityBack() {
        return identityBack;
    }

    public void setIdentityBack(String identityBack) {
        this.identityBack = identityBack;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 10)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 10)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "county", nullable = true, length = 50)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "enterprise_level", nullable = true, length = 10)
    public String getEnterpriseLevel() {
        return enterpriseLevel;
    }

    public void setEnterpriseLevel(String enterpriseLevel) {
        this.enterpriseLevel = enterpriseLevel;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "create_uid", nullable = true)
    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    @Basic
    @Column(name = "update_uid", nullable = true)
    public Long getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantInfoEntity that = (MerchantInfoEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (merchantCode != null ? !merchantCode.equals(that.merchantCode) : that.merchantCode != null) return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (merchantType != null ? !merchantType.equals(that.merchantType) : that.merchantType != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (enterpriseType != null ? !enterpriseType.equals(that.enterpriseType) : that.enterpriseType != null)
            return false;
        if (enterpriseProperty != null ? !enterpriseProperty.equals(that.enterpriseProperty) : that.enterpriseProperty != null)
            return false;
        if (businessLicense != null ? !businessLicense.equals(that.businessLicense) : that.businessLicense != null)
            return false;
        if (identityFront != null ? !identityFront.equals(that.identityFront) : that.identityFront != null)
            return false;
        if (identityBack != null ? !identityBack.equals(that.identityBack) : that.identityBack != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (enterpriseLevel != null ? !enterpriseLevel.equals(that.enterpriseLevel) : that.enterpriseLevel != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (updateUid != null ? !updateUid.equals(that.updateUid) : that.updateUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (merchantCode != null ? merchantCode.hashCode() : 0);
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (merchantType != null ? merchantType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (enterpriseType != null ? enterpriseType.hashCode() : 0);
        result = 31 * result + (enterpriseProperty != null ? enterpriseProperty.hashCode() : 0);
        result = 31 * result + (businessLicense != null ? businessLicense.hashCode() : 0);
        result = 31 * result + (identityFront != null ? identityFront.hashCode() : 0);
        result = 31 * result + (identityBack != null ? identityBack.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (enterpriseLevel != null ? enterpriseLevel.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (updateUid != null ? updateUid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "merchantInfoByMerchantId")
    public Collection<MerAccountEntity> getMerAccountsById() {
        return merAccountsById;
    }

    public void setMerAccountsById(Collection<MerAccountEntity> merAccountsById) {
        this.merAccountsById = merAccountsById;
    }

    @OneToMany(mappedBy = "merchantInfoByMerId")
    public Collection<MerchantBrandRelEntity> getMerchantBrandRelsById() {
        return merchantBrandRelsById;
    }

    public void setMerchantBrandRelsById(Collection<MerchantBrandRelEntity> merchantBrandRelsById) {
        this.merchantBrandRelsById = merchantBrandRelsById;
    }

    @ManyToOne
    @JoinColumn(name = "create_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByCreateUid() {
        return merAccountByCreateUid;
    }

    public void setMerAccountByCreateUid(MerAccountEntity merAccountByCreateUid) {
        this.merAccountByCreateUid = merAccountByCreateUid;
    }

    @ManyToOne
    @JoinColumn(name = "update_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByUpdateUid() {
        return merAccountByUpdateUid;
    }

    public void setMerAccountByUpdateUid(MerAccountEntity merAccountByUpdateUid) {
        this.merAccountByUpdateUid = merAccountByUpdateUid;
    }

    @OneToMany(mappedBy = "merchantInfoByMerId")
    public Collection<MerchantModelsRelEntity> getMerchantModelsRelsById() {
        return merchantModelsRelsById;
    }

    public void setMerchantModelsRelsById(Collection<MerchantModelsRelEntity> merchantModelsRelsById) {
        this.merchantModelsRelsById = merchantModelsRelsById;
    }

    @OneToMany(mappedBy = "merchantInfoByMerId")
    public Collection<MerchantScopeRelEntity> getMerchantScopeRelsById() {
        return merchantScopeRelsById;
    }

    public void setMerchantScopeRelsById(Collection<MerchantScopeRelEntity> merchantScopeRelsById) {
        this.merchantScopeRelsById = merchantScopeRelsById;
    }

    @OneToMany(mappedBy = "merchantInfoByMerUid")
    public Collection<ReceiveDeliveryAddressEntity> getReceiveDeliveryAddressesById() {
        return receiveDeliveryAddressesById;
    }

    public void setReceiveDeliveryAddressesById(Collection<ReceiveDeliveryAddressEntity> receiveDeliveryAddressesById) {
        this.receiveDeliveryAddressesById = receiveDeliveryAddressesById;
    }
}
