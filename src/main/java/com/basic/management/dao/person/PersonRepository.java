package com.basic.management.dao.person;

import com.basic.management.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * 人员信息持久化
 *
 * @author fujie
 */
public interface PersonRepository extends JpaRepository<Person,String> {

    /**
     * 根据身份证编号查询人员信息
     *
     * @param idCard 身份证
     * @return Person
     */
    Person findByIdCard (@Param("idCard") String idCard);

}
