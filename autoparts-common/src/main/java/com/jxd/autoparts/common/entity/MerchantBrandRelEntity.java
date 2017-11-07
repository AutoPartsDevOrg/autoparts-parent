package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "merchant_brand_rel", schema = "autoparts", catalog = "")
public class MerchantBrandRelEntity extends IdEntity {

    private Long brandId;
    private Long merId;
    private CarBrandEntity carBrandByBrandId;
    private MerchantInfoEntity merchantInfoByMerId;



    @Basic
    @Column(name = "brand_id", nullable = true)
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "mer_id", nullable = true)
    public Long getMerId() {
        return merId;
    }

    public void setMerId(Long merId) {
        this.merId = merId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantBrandRelEntity that = (MerchantBrandRelEntity) o;

        if (id != that.id) return false;
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        if (merId != null ? !merId.equals(that.merId) : that.merId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (merId != null ? merId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CarBrandEntity getCarBrandByBrandId() {
        return carBrandByBrandId;
    }

    public void setCarBrandByBrandId(CarBrandEntity carBrandByBrandId) {
        this.carBrandByBrandId = carBrandByBrandId;
    }

    @ManyToOne
    @JoinColumn(name = "mer_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MerchantInfoEntity getMerchantInfoByMerId() {
        return merchantInfoByMerId;
    }

    public void setMerchantInfoByMerId(MerchantInfoEntity merchantInfoByMerId) {
        this.merchantInfoByMerId = merchantInfoByMerId;
    }
}
