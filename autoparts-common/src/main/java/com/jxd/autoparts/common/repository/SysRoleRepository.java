package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRoleEntity,Long> {

    /**
     * 根据账号id 获取角色集合
     * @param id
     * @return
     */
    @Query(value = "select sr.* from sys_role sr left join account_role_rel ar on sr.id=ar.role_id left join mer_account ma on ar.mer_id=ma.id where ma.id=?", nativeQuery = true)
    List<SysRoleEntity> findRolesByMerAccId(Long id);

    /**
     * 根据账号token 获取角色集合
     * @param utoken
     * @return
     */
    @Query(value = "select sr.* from sys_role sr left join account_role_rel ar on sr.id=ar.role_id left join mer_account ma on ar.mer_id=ma.id where ma.utoken=?", nativeQuery = true)
    List<SysRoleEntity> findRolesByUtoken(String utoken);

}
