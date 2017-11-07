package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "logistics_vehicle", schema = "autoparts", catalog = "")
public class LogisticsVehicleEntity extends IdEntity {

    private String vehicleName;
    private Long accountId;
    private String licensePlate;
    private String vehicleCode;
    private Integer status;
    private String type;
    private Date createTime;
    private MerAccountEntity merAccountByAccountId;



    @Basic
    @Column(name = "vehicle_name", nullable = true, length = 20)
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Basic
    @Column(name = "account_id", nullable = true)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "license_plate", nullable = true, length = 20)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Basic
    @Column(name = "vehicle_code", nullable = true, length = 20)
    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
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
    @Column(name = "type", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        LogisticsVehicleEntity that = (LogisticsVehicleEntity) o;

        if (id != that.id) return false;
        if (vehicleName != null ? !vehicleName.equals(that.vehicleName) : that.vehicleName != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (licensePlate != null ? !licensePlate.equals(that.licensePlate) : that.licensePlate != null) return false;
        if (vehicleCode != null ? !vehicleCode.equals(that.vehicleCode) : that.vehicleCode != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (vehicleName != null ? vehicleName.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (licensePlate != null ? licensePlate.hashCode() : 0);
        result = 31 * result + (vehicleCode != null ? vehicleCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByAccountId() {
        return merAccountByAccountId;
    }

    public void setMerAccountByAccountId(MerAccountEntity merAccountByAccountId) {
        this.merAccountByAccountId = merAccountByAccountId;
    }
}
