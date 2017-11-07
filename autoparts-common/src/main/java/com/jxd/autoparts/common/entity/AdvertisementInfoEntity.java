package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "advertisement_info", schema = "autoparts", catalog = "")
public class AdvertisementInfoEntity extends IdEntity {

    private String name;
    private String content;
    private Date effectiveTime;
    private Date invalidTime;
    private String imagePath;
    private String behaviorType;
    private String behaviorValue;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Long createUid;
    private Long updateUid;
    private int version;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByUpdateUid;



    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "effective_time", nullable = true)
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    @Basic
    @Column(name = "invalid_time", nullable = true)
    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 100)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "behavior_type", nullable = true, length = 20)
    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    @Basic
    @Column(name = "behavior_value", nullable = true, length = 20)
    public String getBehaviorValue() {
        return behaviorValue;
    }

    public void setBehaviorValue(String behaviorValue) {
        this.behaviorValue = behaviorValue;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "create_uid", nullable = true)
    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    @Basic
    @Column(name = "update_uid", nullable = true)
    public Long getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementInfoEntity that = (AdvertisementInfoEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (effectiveTime != null ? !effectiveTime.equals(that.effectiveTime) : that.effectiveTime != null)
            return false;
        if (invalidTime != null ? !invalidTime.equals(that.invalidTime) : that.invalidTime != null) return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (behaviorType != null ? !behaviorType.equals(that.behaviorType) : that.behaviorType != null) return false;
        if (behaviorValue != null ? !behaviorValue.equals(that.behaviorValue) : that.behaviorValue != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (updateUid != null ? !updateUid.equals(that.updateUid) : that.updateUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (effectiveTime != null ? effectiveTime.hashCode() : 0);
        result = 31 * result + (invalidTime != null ? invalidTime.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (behaviorType != null ? behaviorType.hashCode() : 0);
        result = 31 * result + (behaviorValue != null ? behaviorValue.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (updateUid != null ? updateUid.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "create_uid", referencedColumnName = "id",insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByCreateUid() {
        return merAccountByCreateUid;
    }

    public void setMerAccountByCreateUid(MerAccountEntity merAccountByCreateUid) {
        this.merAccountByCreateUid = merAccountByCreateUid;
    }

    @ManyToOne
    @JoinColumn(name = "update_uid", referencedColumnName = "id",insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByUpdateUid() {
        return merAccountByUpdateUid;
    }

    public void setMerAccountByUpdateUid(MerAccountEntity merAccountByUpdateUid) {
        this.merAccountByUpdateUid = merAccountByUpdateUid;
    }
}
