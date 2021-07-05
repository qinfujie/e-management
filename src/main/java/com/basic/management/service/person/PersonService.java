package com.basic.management.service.person;

import cn.hutool.core.util.ObjectUtil;
import com.basic.management.config.BizException;
import com.basic.management.dao.person.PersonRepository;
import com.basic.management.dto.person.PersonInsertDto;
import com.basic.management.dto.person.PersonQueryDto;
import com.basic.management.dto.person.PersonUpdateDto;
import com.basic.management.entity.person.Person;
import com.basic.management.mapper.person.PersonMapper;
import com.basic.management.utils.MathUtil;
import com.basic.management.utils.PageModel;
import com.basic.management.utils.PageUtil;
import com.basic.management.utils.Result;
import com.basic.management.vo.person.PersonInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 人员信息service
 *
 * @author fujie
 */
@Slf4j
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    /**
     * 添加人员信息
     *
     * @param personInsertDto 人员信息
     */
    public Result insert(PersonInsertDto personInsertDto) {
        // 查询人员信息
        Person oldPerson = personRepository.findByIdCard(personInsertDto.getIdCard());
        if (!ObjectUtil.isEmpty(oldPerson)) {
            log.error("系统中已存在证件编号:{}", oldPerson.getIdCard());
            throw new BizException("系统中已存在证件编号" + oldPerson.getIdCard());
        }

        // 组装人员信息并新增
        Person person = new Person();
        BeanUtils.copyProperties(personInsertDto, person);
        Person save = personRepository.save(person);

        // 更新人员编号
        save.setNo(MathUtil.getPersonNo(save.getId()));
        personRepository.save(save);
        log.info("新增人员:{},成功!", save.getName());
        return Result.success("新增人员"+ save.getName() +"成功!");
    }

    /**
     * 修改人员信息
     *
     * @param updateDto 人员信息
     */
    public Result update(PersonUpdateDto updateDto) {
        Person person = new Person();
        BeanUtils.copyProperties(updateDto, person);
        try {
            personRepository.save(person);
        } catch (Exception e) {
            log.error("修改人员异常,异常信息为：{}", e.getMessage());
            return Result.error(e.getMessage());
        }
        return Result.success();
    }

    /**
     * 单个删除人员信息
     *
     * @param id 主键
     * @return Result
     */
    public Result delete(Integer id) {
        Person person = Person.builder().id(id).isDelete(true).build();
        personRepository.save(person);
        return Result.success();
    }

    /**
     * 批量删除人员
     *
     * @param ids 主键集合
     * @return Result
     */
    public Result deleteBatch(String ids) {
        for (String s : ids.split(",")) {
            delete(Integer.parseInt(s));
        }
        return Result.success();
    }

    /**
     * 分页查询人员信息
     *
     * @param queryDto 入参
     * @return Result<PageModel<PersonInfoVo>>
     */
    public Result<PageModel<PersonInfoVo>> findPerson (PersonQueryDto queryDto) {
        PageModel<PersonInfoVo> query = PageUtil.query(queryDto.getRow(), queryDto.getPageSize(),
                () -> personMapper.findPersonInfo(queryDto));
        return Result.success(query);
    }

}
