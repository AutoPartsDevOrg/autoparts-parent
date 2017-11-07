package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receive_delivery_address", schema = "autoparts", catalog = "")
public class ReceiveDeliveryAddressEntity extends IdEntity {

    private String province;
    private String city;
    private String country;
    private String address;
    private String type;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Long createUid;
    private Long updateUid;
    private Long merUid;
    private int version;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByUpdateUid;
    private MerchantInfoEntity merchantInfoByMerUid;


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
    @Column(name = "country", nullable = true, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
    @Column(name = "type", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "create_time", nullable = true, length = 20)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true, length = 20)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @Basic
    @Column(name = "mer_uid", nullable = true)
    public Long getMerUid() {
        return merUid;
    }

    public void setMerUid(Long merUid) {
        this.merUid = merUid;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiveDeliveryAddressEntity that = (ReceiveDeliveryAddressEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (updateUid != null ? !updateUid.equals(that.updateUid) : that.updateUid != null) return false;
        if (merUid != null ? !merUid.equals(that.merUid) : that.merUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (updateUid != null ? updateUid.hashCode() : 0);
        result = 31 * result + (merUid != null ? merUid.hashCode() : 0);
        result = 31 * result + version;
        return result;
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

    @ManyToOne
    @JoinColumn(name = "mer_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerchantInfoEntity getMerchantInfoByMerUid() {
        return merchantInfoByMerUid;
    }

    public void setMerchantInfoByMerUid(MerchantInfoEntity merchantInfoByMerUid) {
        this.merchantInfoByMerUid = merchantInfoByMerUid;
    }
}
