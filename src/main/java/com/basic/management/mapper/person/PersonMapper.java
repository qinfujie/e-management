package com.basic.management.mapper.person;

import com.basic.management.dto.person.PersonQueryDto;
import com.basic.management.vo.person.PersonInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人员持久化
 *
 * @author fujie
 */
@Mapper
public interface PersonMapper {

    /**
     * 分页查询人员信息
     *
     * @param queryDto 查询
     * @return List<PersonInfoVo>
     */
    List<PersonInfoVo> findPersonInfo (@Param("queryDto")PersonQueryDto queryDto);
}
