package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "sys_menus", schema = "autoparts", catalog = "")
public class SysMenusEntity extends IdEntity{

    private String name;
    private String descs;
    private String code;
    private Long pid;
    private Integer status;
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
    @Column(name = "code", nullable = true, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "pid", nullable = true)
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

        SysMenusEntity that = (SysMenusEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (descs != null ? !descs.equals(that.descs) : that.descs != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descs != null ? descs.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sysMenusByMenuId")
    public Collection<RoleMenuRelEntity> getRoleMenuRelsById() {
        return roleMenuRelsById;
    }

    public void setRoleMenuRelsById(Collection<RoleMenuRelEntity> roleMenuRelsById) {
        this.roleMenuRelsById = roleMenuRelsById;
    }
}
