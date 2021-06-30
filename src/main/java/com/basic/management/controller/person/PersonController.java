package com.basic.management.controller.person;
import com.basic.management.dto.person.PersonInsertDto;
import com.basic.management.dto.person.PersonUpdateDto;
import com.basic.management.service.person.PersonService;
import com.basic.management.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * 人员Api
 *
 * @author fujie
 */

@RestController
@RequestMapping("/person")
@Api(value = "人员管理", tags = "人员管理")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * 新增人员信息
     *
     * @param personInsertDto 人员基础信息
     * @return Result
     */
    @PostMapping("/insert")
    @ApiOperation(value = "人员新增", notes = "人员新增")
    public Result insert (@RequestBody @Validated PersonInsertDto personInsertDto) {
        return personService.insert(personInsertDto);
    }

    /**
     * 修改人员信息
     *
     * @param updateDto 人员基础信息
     * @return Result
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改人员信息", notes = "修改人员信息")
    public Result update (@RequestBody @Validated PersonUpdateDto updateDto) {
        return personService.update(updateDto);
    }

    /**
     * 根据主键删除人员信息
     *
     * @param id 主键
     * @return Result
     */
    @GetMapping("/delete")
    @ApiOperation(value = "根据主键删除人员信息", notes = "根据主键删除人员信息")
    public Result delete (@RequestParam @NotEmpty(message = "主键不能为空！") Integer id) {
        return personService.delete(id);
    }

    /**
     * 根据主键集删除人员信息
     *
     * @param ids 主键集
     * @return Result
     */
    @GetMapping("/delete")
    @ApiOperation(value = "根据主键集删除人员信息", notes = "根据主键集删除人员信息")
    public Result deleteBatch (@RequestParam @NotEmpty(message = "主键集不能为空！") String ids) {
        return personService.deleteBatch(ids);
    }


}
