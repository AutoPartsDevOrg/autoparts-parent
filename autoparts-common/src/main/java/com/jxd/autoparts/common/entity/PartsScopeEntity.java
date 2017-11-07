package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "parts_scope", schema = "autoparts", catalog = "")
public class PartsScopeEntity extends IdEntity {

    private String scopeName;
    private String scopeDesc;
    private Integer status;
    private Date createTime;
    private Collection<MerchantScopeRelEntity> merchantScopeRelsById;


    @Basic
    @Column(name = "scope_name", nullable = false, length = 20)
    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    @Basic
    @Column(name = "scope_desc", nullable = true, length = 200)
    public String getScopeDesc() {
        return scopeDesc;
    }

    public void setScopeDesc(String scopeDesc) {
        this.scopeDesc = scopeDesc;
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

        PartsScopeEntity that = (PartsScopeEntity) o;

        if (id != that.id) return false;
        if (scopeName != null ? !scopeName.equals(that.scopeName) : that.scopeName != null) return false;
        if (scopeDesc != null ? !scopeDesc.equals(that.scopeDesc) : that.scopeDesc != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (scopeName != null ? scopeName.hashCode() : 0);
        result = 31 * result + (scopeDesc != null ? scopeDesc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "partsScopeByScopeId")
    public Collection<MerchantScopeRelEntity> getMerchantScopeRelsById() {
        return merchantScopeRelsById;
    }

    public void setMerchantScopeRelsById(Collection<MerchantScopeRelEntity> merchantScopeRelsById) {
        this.merchantScopeRelsById = merchantScopeRelsById;
    }
}
