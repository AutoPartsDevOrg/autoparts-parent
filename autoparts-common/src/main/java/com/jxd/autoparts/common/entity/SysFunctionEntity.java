package com.jxd.autoparts.common.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "sys_function", schema = "autoparts", catalog = "")
public class SysFunctionEntity extends IdEntity {

    private String name;
    private String descs;
    private String val;
    private Collection<RoleFunctionRelEntity> roleFunctionRelsById;


    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "descs", nullable = true, length = 100)
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    @Basic
    @Column(name = "val", nullable = true, length = 100)
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysFunctionEntity that = (SysFunctionEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (descs != null ? !descs.equals(that.descs) : that.descs != null) return false;
        if (val != null ? !val.equals(that.val) : that.val != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descs != null ? descs.hashCode() : 0);
        result = 31 * result + (val != null ? val.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sysFunctionByFunctionId")
    public Collection<RoleFunctionRelEntity> getRoleFunctionRelsById() {
        return roleFunctionRelsById;
    }

    public void setRoleFunctionRelsById(Collection<RoleFunctionRelEntity> roleFunctionRelsById) {
        this.roleFunctionRelsById = roleFunctionRelsById;
    }
}
