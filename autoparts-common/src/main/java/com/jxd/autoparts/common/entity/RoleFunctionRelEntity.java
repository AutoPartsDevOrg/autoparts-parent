package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_function_rel", schema = "autoparts", catalog = "")
public class RoleFunctionRelEntity extends IdEntity {

    private Long roleId;
    private Long functionId;
    private SysRoleEntity sysRoleByRoleId;
    private SysFunctionEntity sysFunctionByFunctionId;


    @Basic
    @Column(name = "role_id", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "function_id", nullable = true)
    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleFunctionRelEntity that = (RoleFunctionRelEntity) o;

        if (id != that.id) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (functionId != null ? !functionId.equals(that.functionId) : that.functionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (functionId != null ? functionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SysRoleEntity getSysRoleByRoleId() {
        return sysRoleByRoleId;
    }

    public void setSysRoleByRoleId(SysRoleEntity sysRoleByRoleId) {
        this.sysRoleByRoleId = sysRoleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "function_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SysFunctionEntity getSysFunctionByFunctionId() {
        return sysFunctionByFunctionId;
    }

    public void setSysFunctionByFunctionId(SysFunctionEntity sysFunctionByFunctionId) {
        this.sysFunctionByFunctionId = sysFunctionByFunctionId;
    }
}
