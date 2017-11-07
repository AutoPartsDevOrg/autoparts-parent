package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "waybill_info", schema = "autoparts", catalog = "")
public class WaybillInfoEntity extends IdEntity {

    private String waybillNo;
    private String waybillContent;
    private String status;
    private BigDecimal waybillFree;
    private Date finishTime;
    private Long createMid;
    private Long updateMid;
    private Long sendMid;
    private Integer packageNum;
    private Integer sendType;
    private Date createTime;
    private Date updateTime;
    private Long createUid;
    private Long updateUid;
    private int version;
    private Collection<PackageInfoEntity> packageInfosById;
    private MerchantInfoEntity merchantInfoByCreateMid;
    private MerchantInfoEntity merchantInfoByUpdateMid;
    private MerchantInfoEntity merchantInfoBySendMid;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByUpdateUid;



    @Basic
    @Column(name = "waybill_no", nullable = true, length = 50)
    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    @Basic
    @Column(name = "waybill_content", nullable = true, length = 500)
    public String getWaybillContent() {
        return waybillContent;
    }

    public void setWaybillContent(String waybillContent) {
        this.waybillContent = waybillContent;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "waybill_free", nullable = true, precision = 3)
    public BigDecimal getWaybillFree() {
        return waybillFree;
    }

    public void setWaybillFree(BigDecimal waybillFree) {
        this.waybillFree = waybillFree;
    }

    @Basic
    @Column(name = "finish_time", nullable = true)
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "create_mid", nullable = true)
    public Long getCreateMid() {
        return createMid;
    }

    public void setCreateMid(Long createMid) {
        this.createMid = createMid;
    }

    @Basic
    @Column(name = "update_mid", nullable = true)
    public Long getUpdateMid() {
        return updateMid;
    }

    public void setUpdateMid(Long updateMid) {
        this.updateMid = updateMid;
    }

    @Basic
    @Column(name = "send_mid", nullable = true)
    public Long getSendMid() {
        return sendMid;
    }

    public void setSendMid(Long sendMid) {
        this.sendMid = sendMid;
    }

    @Basic
    @Column(name = "package_num", nullable = true)
    public Integer getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(Integer packageNum) {
        this.packageNum = packageNum;
    }

    @Basic
    @Column(name = "send_type", nullable = true)
    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
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

        WaybillInfoEntity that = (WaybillInfoEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (waybillNo != null ? !waybillNo.equals(that.waybillNo) : that.waybillNo != null) return false;
        if (waybillContent != null ? !waybillContent.equals(that.waybillContent) : that.waybillContent != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (waybillFree != null ? !waybillFree.equals(that.waybillFree) : that.waybillFree != null) return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (createMid != null ? !createMid.equals(that.createMid) : that.createMid != null) return false;
        if (updateMid != null ? !updateMid.equals(that.updateMid) : that.updateMid != null) return false;
        if (sendMid != null ? !sendMid.equals(that.sendMid) : that.sendMid != null) return false;
        if (packageNum != null ? !packageNum.equals(that.packageNum) : that.packageNum != null) return false;
        if (sendType != null ? !sendType.equals(that.sendType) : that.sendType != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (updateUid != null ? !updateUid.equals(that.updateUid) : that.updateUid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (waybillNo != null ? waybillNo.hashCode() : 0);
        result = 31 * result + (waybillContent != null ? waybillContent.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (waybillFree != null ? waybillFree.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (createMid != null ? createMid.hashCode() : 0);
        result = 31 * result + (updateMid != null ? updateMid.hashCode() : 0);
        result = 31 * result + (sendMid != null ? sendMid.hashCode() : 0);
        result = 31 * result + (packageNum != null ? packageNum.hashCode() : 0);
        result = 31 * result + (sendType != null ? sendType.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (updateUid != null ? updateUid.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @OneToMany(mappedBy = "waybillInfoByWaybillId")
    public Collection<PackageInfoEntity> getPackageInfosById() {
        return packageInfosById;
    }

    public void setPackageInfosById(Collection<PackageInfoEntity> packageInfosById) {
        this.packageInfosById = packageInfosById;
    }

    @ManyToOne
    @JoinColumn(name = "create_mid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerchantInfoEntity getMerchantInfoByCreateMid() {
        return merchantInfoByCreateMid;
    }

    public void setMerchantInfoByCreateMid(MerchantInfoEntity merchantInfoByCreateMid) {
        this.merchantInfoByCreateMid = merchantInfoByCreateMid;
    }

    @ManyToOne
    @JoinColumn(name = "update_mid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerchantInfoEntity getMerchantInfoByUpdateMid() {
        return merchantInfoByUpdateMid;
    }

    public void setMerchantInfoByUpdateMid(MerchantInfoEntity merchantInfoByUpdateMid) {
        this.merchantInfoByUpdateMid = merchantInfoByUpdateMid;
    }

    @ManyToOne
    @JoinColumn(name = "send_mid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerchantInfoEntity getMerchantInfoBySendMid() {
        return merchantInfoBySendMid;
    }

    public void setMerchantInfoBySendMid(MerchantInfoEntity merchantInfoBySendMid) {
        this.merchantInfoBySendMid = merchantInfoBySendMid;
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
