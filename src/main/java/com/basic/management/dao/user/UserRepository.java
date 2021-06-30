package com.basic.management.dao.user;
import com.basic.management.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息持久化
 *
 * @author fujie
 */
public interface UserRepository extends JpaRepository<User,String> {
}
