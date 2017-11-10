package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.SysFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysFunctionRepository extends JpaRepository<SysFunctionEntity,Long> {

    /**
     * 根据角色ids 获取功能集合
     * @param roleIds
     * @return
     */
    @Query(value = "select sf.* from sys_function sf left join role_function_rel rf on sf.id=rf.function_id left join sys_role sr on rf.role_id=sr.id where sr.id in(?)", nativeQuery = true)
    List<SysFunctionEntity> findFunctionsByRolesIDs(List<Long> roleIds);

}
