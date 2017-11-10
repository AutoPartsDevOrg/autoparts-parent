package com.jxd.autoparts.common.repository;

import com.jxd.autoparts.common.entity.SysMenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysMenusRepository extends JpaRepository<SysMenusEntity,Long> {

    /**
     * 根据角色ids 获取菜单集合
     * @param roleIds
     * @return
     */
    @Query(value = "select sm.* from sys_menus sm left join role_menu_rel rm on sm.id=rm.menu_id left join sys_role sr on rm.role_id=sr.id where sr.id in(?)", nativeQuery = true)
    List<SysMenusEntity> findMenusByRolesIDs(List<Long> roleIds);

}
