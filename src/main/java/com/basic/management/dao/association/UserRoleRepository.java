package com.basic.management.dao.association;

import com.basic.management.entity.association.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户角色持久化
 *
 * @author fujie
 */
public interface UserRoleRepository extends JpaRepository<UserRole,String> {
}
