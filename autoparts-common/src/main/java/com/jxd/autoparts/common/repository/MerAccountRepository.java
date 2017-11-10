package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.MerAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MerAccountRepository extends JpaRepository<MerAccountEntity,Long> {


    /**
     * 根据utoken 获取账号信息
     * @param utoken
     * @return
     */
    MerAccountEntity findByUtoken(String utoken);

    /**
     * 根据utoken 和 status 获取账号信息
     * @param utoken
     * @param status
     * @return
     */
    @Query(value = "select * from mer_account where utoken=? and status=?", nativeQuery = true)
    MerAccountEntity findByUtoken(String utoken,Integer status);

    /**
     * 根据用户名密码查询账号
     * @param username
     * @param password
     * @return
     */
    MerAccountEntity findByUsernameAndPassword(String username,String password);

    /**
     * 用于判断用户名是否重复
     * @param username
     * @return
     */
    Integer countByUsername(String username);

    /**
     * 更新登陆token
     * @param utoken
     * @param newToken
     * @return
     */
    @Query(value = "update mer_account set utoken=?2 where utoken=?1", nativeQuery = true)
    @Modifying
    int updateUToken(String utoken,String newToken);

    /**
     * 更新登陆token
     * @param id
     * @param newToken
     * @return
     */
    @Query(value = "update mer_account set utoken=?2 where id=?1", nativeQuery = true)
    @Modifying
    int updateUToken(Long id,String newToken);

    /**
     * 更新密码
     * @param utoken
     * @param newPwd
     * @return
     */
    @Query(value = "update mer_account set password=?2 where utoken=?1", nativeQuery = true)
    @Modifying
    int updatePwd(String utoken,String newPwd);

    /**
     * 更新密码
     * @param id
     * @param newPwd
     * @return
     */
    @Query(value = "update mer_account set password=?2 where id=?1", nativeQuery = true)
    @Modifying
    int updatePwd(Long id,String newPwd);

}
