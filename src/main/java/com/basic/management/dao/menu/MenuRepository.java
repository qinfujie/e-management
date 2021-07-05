package com.basic.management.dao.menu;

import com.basic.management.entity.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 菜单持久化
 *
 * @author fujie
 */
public interface MenuRepository extends JpaRepository<Menu,String> {
}
