package com.jxd.autoparts.api.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DemoPj implements Serializable {

    private Long id;
    private String name;
    private List<Object> list = new ArrayList<Object>();

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

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DemoPj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
