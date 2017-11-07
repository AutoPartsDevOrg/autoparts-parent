package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "car_models", schema = "autoparts", catalog = "")
public class CarModelsEntity extends IdEntity {

    private String modelsName;
    private String modelsDesc;
    private String modelsAges;
    private Integer status;
    private Date createTime;
    private Collection<MerchantModelsRelEntity> merchantModelsRelsById;


    @Basic
    @Column(name = "models_name", nullable = false, length = 50)
    public String getModelsName() {
        return modelsName;
    }

    public void setModelsName(String modelsName) {
        this.modelsName = modelsName;
    }

    @Basic
    @Column(name = "models_desc", nullable = true, length = 200)
    public String getModelsDesc() {
        return modelsDesc;
    }

    public void setModelsDesc(String modelsDesc) {
        this.modelsDesc = modelsDesc;
    }

    @Basic
    @Column(name = "models_ages", nullable = true, length = 300)
    public String getModelsAges() {
        return modelsAges;
    }

    public void setModelsAges(String modelsAges) {
        this.modelsAges = modelsAges;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModelsEntity that = (CarModelsEntity) o;

        if (id != that.id) return false;
        if (modelsName != null ? !modelsName.equals(that.modelsName) : that.modelsName != null) return false;
        if (modelsDesc != null ? !modelsDesc.equals(that.modelsDesc) : that.modelsDesc != null) return false;
        if (modelsAges != null ? !modelsAges.equals(that.modelsAges) : that.modelsAges != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (modelsName != null ? modelsName.hashCode() : 0);
        result = 31 * result + (modelsDesc != null ? modelsDesc.hashCode() : 0);
        result = 31 * result + (modelsAges != null ? modelsAges.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "carModelsByModelsId")
    public Collection<MerchantModelsRelEntity> getMerchantModelsRelsById() {
        return merchantModelsRelsById;
    }

    public void setMerchantModelsRelsById(Collection<MerchantModelsRelEntity> merchantModelsRelsById) {
        this.merchantModelsRelsById = merchantModelsRelsById;
    }
}
