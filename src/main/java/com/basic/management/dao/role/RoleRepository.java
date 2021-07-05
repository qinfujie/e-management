package com.basic.management.dao.role;

import com.basic.management.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色持久化
 *
 * @author fujie
 */
public interface RoleRepository extends JpaRepository<Role,String> {
}
