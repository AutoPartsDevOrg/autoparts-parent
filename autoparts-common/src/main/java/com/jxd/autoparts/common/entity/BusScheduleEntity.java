package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "bus_schedule", schema = "autoparts", catalog = "")
public class BusScheduleEntity extends IdEntity {

    private String busSendtime;
    private String busLine;
    private String busExplain;
    private Integer status;
    private Date createTime;
    private Date updateTime;



    @Basic
    @Column(name = "bus_sendtime", nullable = true, length = 20)
    public String getBusSendtime() {
        return busSendtime;
    }

    public void setBusSendtime(String busSendtime) {
        this.busSendtime = busSendtime;
    }

    @Basic
    @Column(name = "bus_line", nullable = true, length = 500)
    public String getBusLine() {
        return busLine;
    }

    public void setBusLine(String busLine) {
        this.busLine = busLine;
    }

    @Basic
    @Column(name = "bus_explain", nullable = true, length = 500)
    public String getBusExplain() {
        return busExplain;
    }

    public void setBusExplain(String busExplain) {
        this.busExplain = busExplain;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusScheduleEntity that = (BusScheduleEntity) o;

        if (id != that.id) return false;
        if (busSendtime != null ? !busSendtime.equals(that.busSendtime) : that.busSendtime != null) return false;
        if (busLine != null ? !busLine.equals(that.busLine) : that.busLine != null) return false;
        if (busExplain != null ? !busExplain.equals(that.busExplain) : that.busExplain != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (busSendtime != null ? busSendtime.hashCode() : 0);
        result = 31 * result + (busLine != null ? busLine.hashCode() : 0);
        result = 31 * result + (busExplain != null ? busExplain.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
