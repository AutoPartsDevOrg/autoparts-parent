package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "location_info", schema = "autoparts", catalog = "")
public class LocationInfoEntity extends IdEntity {

    private String locationLong;
    private String locationDimension;
    private String waybillNo;
    private String packageNo;
    private Long sendUid;
    private Date createTime;
    private MerAccountEntity merAccountBySendUid;



    @Basic
    @Column(name = "location_long", nullable = true, length = 50)
    public String getLocationLong() {
        return locationLong;
    }

    public void setLocationLong(String locationLong) {
        this.locationLong = locationLong;
    }

    @Basic
    @Column(name = "location_dimension", nullable = true, length = 50)
    public String getLocationDimension() {
        return locationDimension;
    }

    public void setLocationDimension(String locationDimension) {
        this.locationDimension = locationDimension;
    }

    @Basic
    @Column(name = "waybill_no", nullable = true, length = 20)
    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    @Basic
    @Column(name = "package_no", nullable = true, length = 20)
    public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo;
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
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationInfoEntity that = (LocationInfoEntity) o;

        if (id != that.id) return false;
        if (locationLong != null ? !locationLong.equals(that.locationLong) : that.locationLong != null) return false;
        if (locationDimension != null ? !locationDimension.equals(that.locationDimension) : that.locationDimension != null)
            return false;
        if (waybillNo != null ? !waybillNo.equals(that.waybillNo) : that.waybillNo != null) return false;
        if (packageNo != null ? !packageNo.equals(that.packageNo) : that.packageNo != null) return false;
        if (sendUid != null ? !sendUid.equals(that.sendUid) : that.sendUid != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (locationLong != null ? locationLong.hashCode() : 0);
        result = 31 * result + (locationDimension != null ? locationDimension.hashCode() : 0);
        result = 31 * result + (waybillNo != null ? waybillNo.hashCode() : 0);
        result = 31 * result + (packageNo != null ? packageNo.hashCode() : 0);
        result = 31 * result + (sendUid != null ? sendUid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "send_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountBySendUid() {
        return merAccountBySendUid;
    }

    public void setMerAccountBySendUid(MerAccountEntity merAccountBySendUid) {
        this.merAccountBySendUid = merAccountBySendUid;
    }
}
