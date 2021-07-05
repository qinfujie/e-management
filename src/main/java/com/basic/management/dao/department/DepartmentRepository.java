package com.basic.management.dao.department;

import com.basic.management.entity.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 单位持久化
 *
 * @author fujie
 */
public interface DepartmentRepository extends JpaRepository<Department,String> {
}
