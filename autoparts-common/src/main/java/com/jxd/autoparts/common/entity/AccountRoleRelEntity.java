package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_role_rel", schema = "autoparts", catalog = "")
public class AccountRoleRelEntity extends IdEntity {

    private Long merId;
    private Long roleId;
    private MerAccountEntity merAccountByMerId;
    private SysRoleEntity sysRoleByRoleId;



    @Basic
    @Column(name = "mer_id", nullable = true)
    public Long getMerId() {
        return merId;
    }

    public void setMerId(Long merId) {
        this.merId = merId;
    }

    @Basic
    @Column(name = "role_id", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountRoleRelEntity that = (AccountRoleRelEntity) o;

        if (id != that.id) return false;
        if (merId != null ? !merId.equals(that.merId) : that.merId != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (merId != null ? merId.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "mer_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByMerId() {
        return merAccountByMerId;
    }

    public void setMerAccountByMerId(MerAccountEntity merAccountByMerId) {
        this.merAccountByMerId = merAccountByMerId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SysRoleEntity getSysRoleByRoleId() {
        return sysRoleByRoleId;
    }

    public void setSysRoleByRoleId(SysRoleEntity sysRoleByRoleId) {
        this.sysRoleByRoleId = sysRoleByRoleId;
    }
}
