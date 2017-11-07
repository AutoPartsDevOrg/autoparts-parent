package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "images_info", schema = "autoparts", catalog = "")
public class ImagesInfoEntity extends IdEntity {

    private String imagesName;
    private String imagesSize;
    private String imagesPath;
    private String imagesType;
    private Integer status;
    private String imagesValue;
    private Date createTime;



    @Basic
    @Column(name = "images_name", nullable = true, length = 50)
    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

    @Basic
    @Column(name = "images_size", nullable = true, length = 20)
    public String getImagesSize() {
        return imagesSize;
    }

    public void setImagesSize(String imagesSize) {
        this.imagesSize = imagesSize;
    }

    @Basic
    @Column(name = "images_path", nullable = true, length = 200)
    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    @Basic
    @Column(name = "images_type", nullable = true, length = 10)
    public String getImagesType() {
        return imagesType;
    }

    public void setImagesType(String imagesType) {
        this.imagesType = imagesType;
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
    @Column(name = "images_value", nullable = true, length = 100)
    public String getImagesValue() {
        return imagesValue;
    }

    public void setImagesValue(String imagesValue) {
        this.imagesValue = imagesValue;
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

        ImagesInfoEntity that = (ImagesInfoEntity) o;

        if (id != that.id) return false;
        if (imagesName != null ? !imagesName.equals(that.imagesName) : that.imagesName != null) return false;
        if (imagesSize != null ? !imagesSize.equals(that.imagesSize) : that.imagesSize != null) return false;
        if (imagesPath != null ? !imagesPath.equals(that.imagesPath) : that.imagesPath != null) return false;
        if (imagesType != null ? !imagesType.equals(that.imagesType) : that.imagesType != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (imagesValue != null ? !imagesValue.equals(that.imagesValue) : that.imagesValue != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (imagesName != null ? imagesName.hashCode() : 0);
        result = 31 * result + (imagesSize != null ? imagesSize.hashCode() : 0);
        result = 31 * result + (imagesPath != null ? imagesPath.hashCode() : 0);
        result = 31 * result + (imagesType != null ? imagesType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (imagesValue != null ? imagesValue.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
