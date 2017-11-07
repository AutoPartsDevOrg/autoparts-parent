package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "car_brand", schema = "autoparts", catalog = "")
public class CarBrandEntity extends IdEntity {

    private String brandName;
    private String brandDesc;
    private Integer status;
    private Date createTime;
    private Collection<MerchantBrandRelEntity> merchantBrandRelsById;



    @Basic
    @Column(name = "brand_name", nullable = false, length = 20)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "brand_desc", nullable = true, length = 200)
    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
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
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarBrandEntity that = (CarBrandEntity) o;

        if (id != that.id) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (brandDesc != null ? !brandDesc.equals(that.brandDesc) : that.brandDesc != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (brandDesc != null ? brandDesc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "carBrandByBrandId")
    public Collection<MerchantBrandRelEntity> getMerchantBrandRelsById() {
        return merchantBrandRelsById;
    }

    public void setMerchantBrandRelsById(Collection<MerchantBrandRelEntity> merchantBrandRelsById) {
        this.merchantBrandRelsById = merchantBrandRelsById;
    }
}
