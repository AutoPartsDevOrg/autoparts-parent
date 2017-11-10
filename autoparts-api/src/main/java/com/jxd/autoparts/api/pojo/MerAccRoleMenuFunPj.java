package com.jxd.autoparts.api.pojo;

import java.util.ArrayList;
import java.util.List;

public class MerAccRoleMenuFunPj extends BasePj {

    private MerAccountPj account;
    private MerchantInfoPj merchant;
    private List<SysFunctionPj> functions = new ArrayList<SysFunctionPj>();
    private List<SysMenusPj> meuns = new ArrayList<SysMenusPj>();
    private List<SysRolePj> roles = new ArrayList<SysRolePj>();

    public MerAccRoleMenuFunPj() {
    }

    public MerAccRoleMenuFunPj(MerAccountPj account, MerchantInfoPj merchant, List<SysFunctionPj> functions, List<SysMenusPj> meuns, List<SysRolePj> roles) {
        this.account = account;
        this.merchant = merchant;
        this.functions = functions;
        this.meuns = meuns;
        this.roles = roles;
    }

    public MerAccountPj getAccount() {
        return account;
    }

    public void setAccount(MerAccountPj account) {
        this.account = account;
    }

    public MerchantInfoPj getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantInfoPj merchant) {
        this.merchant = merchant;
    }

    public List<SysFunctionPj> getFunctions() {
        return functions;
    }

    public void setFunctions(List<SysFunctionPj> functions) {
        this.functions = functions;
    }

    public List<SysMenusPj> getMeuns() {
        return meuns;
    }

    public void setMeuns(List<SysMenusPj> meuns) {
        this.meuns = meuns;
    }

    public List<SysRolePj> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRolePj> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "MerAccRoleMenuFunPj{" +
                "account=" + account +
                ", merchant=" + merchant +
                ", functions=" + functions +
                ", meuns=" + meuns +
                ", roles=" + roles +
                '}';
    }
}
