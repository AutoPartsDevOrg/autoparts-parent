package com.jxd.autoparts.api.pojo;

import com.jxd.autoparts.common.entity.MerAccountEntity;

import java.util.Date;

public class MerAccountPj extends BasePj {

    private Long id;
    private MerSimAccountPj createUser;
    private MerSimAccountPj updateUser;
    private String nickName;
    private String name;
    private Integer status;
    private String username;
    private String password;
    private String talkUid;
    private Integer talkStatus;
    private Date createTime;
    private Date updateTime;
    private Long merchantId;
    private String utoken;


    public MerAccountPj() {
    }

    public MerAccountPj(MerAccountEntity ety) {
        copy(this,ety);
        if(ety!=null && ety.getMerAccountByCreateUid()!=null){
            this.createUser = new MerSimAccountPj(ety.getMerAccountByCreateUid());
        }
        if(ety!=null && ety.getMerAccountByUpdateUid()!=null){
            this.updateUser = new MerSimAccountPj(ety.getMerAccountByUpdateUid());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MerSimAccountPj getCreateUser() {
        return createUser;
    }

    public void setCreateUser(MerSimAccountPj createUser) {
        this.createUser = createUser;
    }

    public MerSimAccountPj getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(MerSimAccountPj updateUser) {
        this.updateUser = updateUser;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTalkUid() {
        return talkUid;
    }

    public void setTalkUid(String talkUid) {
        this.talkUid = talkUid;
    }

    public Integer getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(Integer talkStatus) {
        this.talkStatus = talkStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getUtoken() {
        return utoken;
    }

    public void setUtoken(String utoken) {
        this.utoken = utoken;
    }

    @Override
    public String toString() {
        return "MerAccountPj{" +
                "id=" + id +
                "createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", talkUid='" + talkUid + '\'' +
                ", talkStatus=" + talkStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", merchantId=" + merchantId +
                ", utoken='" + utoken + '\'' +
                '}';
    }
}
