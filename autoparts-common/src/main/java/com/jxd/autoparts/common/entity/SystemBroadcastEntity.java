package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "system_broadcast", schema = "autoparts", catalog = "")
public class SystemBroadcastEntity extends IdEntity {

    private String name;
    private String content;
    private String type;
    private String send;
    private String receive;
    private Integer status;
    private Long createUid;
    private Long auditingUid;
    private Date auditingTime;
    private Date createTime;
    private MerAccountEntity merAccountByCreateUid;
    private MerAccountEntity merAccountByAuditingUid;



    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "send", nullable = true, length = 100)
    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    @Basic
    @Column(name = "receive", nullable = true, length = 100)
    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
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
    @Column(name = "create_uid", nullable = true)
    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    @Basic
    @Column(name = "auditing_uid", nullable = true)
    public Long getAuditingUid() {
        return auditingUid;
    }

    public void setAuditingUid(Long auditingUid) {
        this.auditingUid = auditingUid;
    }

    @Basic
    @Column(name = "auditing_time", nullable = true)
    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
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

        SystemBroadcastEntity that = (SystemBroadcastEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (send != null ? !send.equals(that.send) : that.send != null) return false;
        if (receive != null ? !receive.equals(that.receive) : that.receive != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createUid != null ? !createUid.equals(that.createUid) : that.createUid != null) return false;
        if (auditingUid != null ? !auditingUid.equals(that.auditingUid) : that.auditingUid != null) return false;
        if (auditingTime != null ? !auditingTime.equals(that.auditingTime) : that.auditingTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (send != null ? send.hashCode() : 0);
        result = 31 * result + (receive != null ? receive.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createUid != null ? createUid.hashCode() : 0);
        result = 31 * result + (auditingUid != null ? auditingUid.hashCode() : 0);
        result = 31 * result + (auditingTime != null ? auditingTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "auditing_uid", referencedColumnName = "id", insertable = false, updatable = false)
    public MerAccountEntity getMerAccountByAuditingUid() {
        return merAccountByAuditingUid;
    }

    public void setMerAccountByAuditingUid(MerAccountEntity merAccountByAuditingUid) {
        this.merAccountByAuditingUid = merAccountByAuditingUid;
    }
}
