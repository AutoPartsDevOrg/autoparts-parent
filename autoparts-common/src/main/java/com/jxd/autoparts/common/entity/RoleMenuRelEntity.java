package com.jxd.autoparts.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_menu_rel", schema = "autoparts", catalog = "")
public class RoleMenuRelEntity extends IdEntity{

    private Long roleId;
    private Long menuId;
    private SysRoleEntity sysRoleByRoleId;
    private SysMenusEntity sysMenusByMenuId;



    @Basic
    @Column(name = "role_id", nullable = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleMenuRelEntity that = (RoleMenuRelEntity) o;

        if (id != that.id) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (menuId != null ? menuId.hashCode() : 0);
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
    @JoinColumn(name = "menu_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SysMenusEntity getSysMenusByMenuId() {
        return sysMenusByMenuId;
    }

    public void setSysMenusByMenuId(SysMenusEntity sysMenusByMenuId) {
        this.sysMenusByMenuId = sysMenusByMenuId;
    }
}
