package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "merchant_scope_rel", schema = "autoparts", catalog = "")
public class MerchantScopeRelEntity extends IdEntity {

    private Long scopeId;
    private Long merId;
    private PartsScopeEntity partsScopeByScopeId;
    private MerchantInfoEntity merchantInfoByMerId;


    @Basic
    @Column(name = "scope_id", nullable = true)
    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
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

        MerchantScopeRelEntity that = (MerchantScopeRelEntity) o;

        if (id != that.id) return false;
        if (scopeId != null ? !scopeId.equals(that.scopeId) : that.scopeId != null) return false;
        if (merId != null ? !merId.equals(that.merId) : that.merId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (scopeId != null ? scopeId.hashCode() : 0);
        result = 31 * result + (merId != null ? merId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "scope_id", referencedColumnName = "id", insertable = false, updatable = false)
    public PartsScopeEntity getPartsScopeByScopeId() {
        return partsScopeByScopeId;
    }

    public void setPartsScopeByScopeId(PartsScopeEntity partsScopeByScopeId) {
        this.partsScopeByScopeId = partsScopeByScopeId;
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
