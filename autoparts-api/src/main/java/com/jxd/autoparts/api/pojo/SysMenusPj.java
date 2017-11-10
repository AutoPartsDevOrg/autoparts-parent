package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.SysMenusEntity;

public class SysMenusPj extends BasePj {

    private Long id;
    private String name;
    private String descs;
    private String code;
    private Long pid;
    private Integer status;

    public SysMenusPj() {
    }

    public SysMenusPj(SysMenusEntity ety) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysMenusPj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", code='" + code + '\'' +
                ", pid=" + pid +
                ", status=" + status +
                '}';
    }
}
