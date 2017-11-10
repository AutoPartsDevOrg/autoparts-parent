package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.SysRoleEntity;

public class SysRolePj extends BasePj {

    private Long id;
    private String name;
    private String descs;
    private String type;
    private Integer status;

    public SysRolePj() {
    }

    public SysRolePj(SysRoleEntity ety) {
        copy(this,ety);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRolePj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
