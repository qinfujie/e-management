package com.basic.management.dao.association;

import com.basic.management.entity.association.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色菜单持久化
 *
 * @author fujie
 */
public interface RoleMenuRepository extends JpaRepository<RoleMenu,String> {
}
