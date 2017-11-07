package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "sys_role", schema = "autoparts", catalog = "")
public class SysRoleEntity extends IdEntity {

    private String name;
    private String descs;
    private String type;
    private Integer status;
    private Collection<AccountRoleRelEntity> accountRoleRelsById;
    private Collection<RoleFunctionRelEntity> roleFunctionRelsById;
    private Collection<RoleMenuRelEntity> roleMenuRelsById;



    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descs", nullable = true, length = 100)
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleEntity that = (SysRoleEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (descs != null ? !descs.equals(that.descs) : that.descs != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descs != null ? descs.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sysRoleByRoleId")
    public Collection<AccountRoleRelEntity> getAccountRoleRelsById() {
        return accountRoleRelsById;
    }

    public void setAccountRoleRelsById(Collection<AccountRoleRelEntity> accountRoleRelsById) {
        this.accountRoleRelsById = accountRoleRelsById;
    }

    @OneToMany(mappedBy = "sysRoleByRoleId")
    public Collection<RoleFunctionRelEntity> getRoleFunctionRelsById() {
        return roleFunctionRelsById;
    }

    public void setRoleFunctionRelsById(Collection<RoleFunctionRelEntity> roleFunctionRelsById) {
        this.roleFunctionRelsById = roleFunctionRelsById;
    }

    @OneToMany(mappedBy = "sysRoleByRoleId")
    public Collection<RoleMenuRelEntity> getRoleMenuRelsById() {
        return roleMenuRelsById;
    }

    public void setRoleMenuRelsById(Collection<RoleMenuRelEntity> roleMenuRelsById) {
        this.roleMenuRelsById = roleMenuRelsById;
    }
}
