package com.jxd.autoparts.api.interfaces;

import com.jxd.autoparts.api.pojo.MerAccRoleMenuFunPj;
import com.jxd.autoparts.api.pojo.MerAccountPj;
import com.jxd.autoparts.common.entity.MerAccountEntity;
import java.util.List;
import java.util.Map;

public interface IMerAccoutService {

    /**
     * 根据utoken 获取账号信息
     * @param utoken
     * @return
     */
    MerAccountPj findByUtoken(String utoken);


    /**
     * 根据utoken 和 status 获取账号信息
     * @param utoken
     * @param status
     * @return
     */
    MerAccountPj findByUtoken(String utoken,Integer status);


    /**
     * 根据账号ID 获取角色、菜单、功能集合
     * key： roles 、menus 、functions
     * @param id
     * @return
     */
    Map<String,Object> getRMFByMeraccId(Long id);


    /**
     * 根据账号utoken 获取角色、菜单、功能集合
     * key： roles 、menus 、functions
     * @param utoken
     * @return
     */
    Map<String,Object> getRMFByUtoken(String utoken);

    /**
     * 根据账号ID 获取角色、菜单、功能集合
     * @param id
     * @return
     */
    MerAccRoleMenuFunPj getRMFPjByMeraccId(Long id);

    /**
     * 根据账号utoken 获取角色、菜单、功能集合
     * @param utoken
     * @return
     */
    MerAccRoleMenuFunPj getRMFPjByUtoken(String utoken);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    MerAccountPj login(String username,String password);

    /**
     * 登出
     * @param utoken
     * @return
     */
    boolean loginout(String utoken);

    /**
     * 登出
     * @param id
     * @return
     */
    boolean loginout(Long id);

    /**
     * 修改密码
     * @param utoken
     * @param newPwd
     * @return
     */
    boolean modifyPwd(String utoken,String newPwd);

    /**
     * 修改密码
     * @param id
     * @param newPwd
     * @return
     */
    boolean modifyPwd(Long id,String newPwd);

    /**
     * 判断就密码是否正确
     * @param utoken
     * @param oldPwd
     * @return
     */
    boolean oldPwdIsRight(String utoken,String oldPwd);

    /**
     * 判断就密码是否正确
     * @param id
     * @param oldPwd
     * @return
     */
    boolean oldPwdIsRight(Long id,String oldPwd);

}
