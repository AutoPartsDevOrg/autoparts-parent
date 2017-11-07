package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "merchant_models_rel", schema = "autoparts", catalog = "")
public class MerchantModelsRelEntity extends IdEntity {

    private Long modelsId;
    private Long merId;
    private CarModelsEntity carModelsByModelsId;
    private MerchantInfoEntity merchantInfoByMerId;


    @Basic
    @Column(name = "models_id", nullable = true)
    public Long getModelsId() {
        return modelsId;
    }

    public void setModelsId(Long modelsId) {
        this.modelsId = modelsId;
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

        MerchantModelsRelEntity that = (MerchantModelsRelEntity) o;

        if (id != that.id) return false;
        if (modelsId != null ? !modelsId.equals(that.modelsId) : that.modelsId != null) return false;
        if (merId != null ? !merId.equals(that.merId) : that.merId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (modelsId != null ? modelsId.hashCode() : 0);
        result = 31 * result + (merId != null ? merId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "models_id", referencedColumnName = "id", insertable = false, updatable = false)
    public CarModelsEntity getCarModelsByModelsId() {
        return carModelsByModelsId;
    }

    public void setCarModelsByModelsId(CarModelsEntity carModelsByModelsId) {
        this.carModelsByModelsId = carModelsByModelsId;
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
