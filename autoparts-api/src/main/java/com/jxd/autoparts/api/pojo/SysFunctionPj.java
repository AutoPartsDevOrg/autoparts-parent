package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.SysFunctionEntity;

public class SysFunctionPj extends BasePj {

    private Long id;
    private String name;
    private String descs;
    private String val;

    public SysFunctionPj() {
    }

    public SysFunctionPj(SysFunctionEntity ety) {
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

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SysFunctionPj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
