package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "package_info", schema = "autoparts", catalog = "")
public class PackageInfoEntity extends IdEntity {

    private String packageNo;
    private Long waybillId;
    private String waybillNo;
    private Long sendUid;
    private Long parentUid;
    private Integer status;
    private Integer collectionMoney;
    private Integer signOrder;
    private Date receiveTime;
    private Date signTime;
    private Date createTime;
    private Date updateTime;
    private Long createUid;
    private Long updateUid;
    private int version;
    private WaybillInfoEntity waybillInfoByWaybillId;
    private MerAccountEntity merAccountBySendUid;
    private MerAccountEntity merAccountByParentUid;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByUpdateUid;


    @Basic
    @Column(name = "package_no", nullable = true, length = 50)
    public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
    }

    @Basic
    @Column(name = "waybill_id", nullable = true)
    public Long getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    @Basic
    @Column(name = "waybill_no", nullable = true, length = 50)
    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    @Basic
    @Column(name = "send_uid", nullable = true)
    public Long getSendUid() {
        return sendUid;
    }

    public void setSendUid(Long sendUid) {
        this.sendUid = sendUid;
    }

    @Basic
    @Column(name = "parent_uid", nullable = true)
    public Long getParentUid() {
        return parentUid;
    }

    public void setParentUid(Long parentUid) {
        this.parentUid = parentUid;
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
    @Column(name = "collection_money", nullable = true)
    public Integer getCollectionMoney() {
        return collectionMoney;
    }

    public void setCollectionMoney(Integer collectionMoney) {
        this.collectionMoney = collectionMoney;
    }

    @Basic
    @Column(name = "sign_order", nullable = true)
    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

    @Basic
    @Column(name = "receive_time", nullable = true)
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Basic
    @Column(name = "sign_time", nullable = true)
    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
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

        PackageInfoEntity that = (PackageInfoEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (packageNo != null ? !packageNo.equals(that.packageNo) : that.packageNo != null) return false;
        if (waybillId != null ? !waybillId.equals(that.waybillId) : that.waybillId != null) return false;
        if (waybillNo != null ? !waybillNo.equals(that.waybillNo) : that.waybillNo != null) return false;
        if (sendUid != null ? !sendUid.equals(that.sendUid) : that.sendUid != null) return false;
        if (parentUid != null ? !parentUid.equals(that.parentUid) : that.parentUid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (collectionMoney != null ? !collectionMoney.equals(that.collectionMoney) : that.collectionMoney != null)
            return false;
        if (signOrder != null ? !signOrder.equals(that.signOrder) : that.signOrder != null) return false;
        if (receiveTime != null ? !receiveTime.equals(that.receiveTime) : that.receiveTime != null) return false;
        if (signTime != null ? !signTime.equals(that.signTime) : that.signTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (updateUid != null ? !updateUid.equals(that.updateUid) : that.updateUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (packageNo != null ? packageNo.hashCode() : 0);
        result = 31 * result + (waybillId != null ? waybillId.hashCode() : 0);
        result = 31 * result + (waybillNo != null ? waybillNo.hashCode() : 0);
        result = 31 * result + (sendUid != null ? sendUid.hashCode() : 0);
        result = 31 * result + (parentUid != null ? parentUid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (collectionMoney != null ? collectionMoney.hashCode() : 0);
        result = 31 * result + (signOrder != null ? signOrder.hashCode() : 0);
        result = 31 * result + (receiveTime != null ? receiveTime.hashCode() : 0);
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (updateUid != null ? updateUid.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "waybill_id", referencedColumnName = "id", insertable = false, updatable = false)
    public WaybillInfoEntity getWaybillInfoByWaybillId() {
        return waybillInfoByWaybillId;
    }

    public void setWaybillInfoByWaybillId(WaybillInfoEntity waybillInfoByWaybillId) {
        this.waybillInfoByWaybillId = waybillInfoByWaybillId;
    }

    @ManyToOne
    @JoinColumn(name = "send_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountBySendUid() {
        return merAccountBySendUid;
    }

    public void setMerAccountBySendUid(MerAccountEntity merAccountBySendUid) {
        this.merAccountBySendUid = merAccountBySendUid;
    }

    @ManyToOne
    @JoinColumn(name = "parent_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByParentUid() {
        return merAccountByParentUid;
    }

    public void setMerAccountByParentUid(MerAccountEntity merAccountByParentUid) {
        this.merAccountByParentUid = merAccountByParentUid;
    }

    @ManyToOne
    @JoinColumn(name = "create_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByCreateUid() {
        return merAccountByCreateUid;
    }

    public void setMerAccountByCreateUid(MerAccountEntity merAccountByCreateUid) {
        this.merAccountByCreateUid = merAccountByCreateUid;
    }

    @ManyToOne
    @JoinColumn(name = "update_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByUpdateUid() {
        return merAccountByUpdateUid;
    }

    public void setMerAccountByUpdateUid(MerAccountEntity merAccountByUpdateUid) {
        this.merAccountByUpdateUid = merAccountByUpdateUid;
    }
}
