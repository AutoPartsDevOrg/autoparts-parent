package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.MerAccountEntity;

public class MerSimAccountPj extends BasePj {

    private Long id;
    private String nickName;
    private String name;
    private Integer status;
    private String username;

    public MerSimAccountPj(){

    }

    public MerSimAccountPj(MerAccountEntity ety){
        copy(this,ety);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "MerSimAccountPj{" +
                "id=" + id +
                "nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
