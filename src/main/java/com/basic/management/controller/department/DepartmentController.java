package com.basic.management.controller.department;
import com.basic.management.dto.department.DepartmentAddDto;
import com.basic.management.dto.department.DepartmentQueryDto;
import com.basic.management.dto.department.DepartmentUpdateDto;
import com.basic.management.service.department.DepartmentService;
import com.basic.management.utils.PageModel;
import com.basic.management.utils.Result;
import com.basic.management.vo.department.DepartmentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 单位管理Api
 *
 * @author fujie
 */

@RestController
@RequestMapping("/department")
@Api(value = "DepartmentController",tags = "单位管理Api")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 新增单位信息
     *
     * @param addDto 新增入参
     * @return Result
     */
    @PostMapping("/insert")
    @ApiOperation(value = "新增单位信息",notes = "新增单位信息")
    public Result insert (@RequestBody @Validated DepartmentAddDto addDto) {
        return departmentService.insert(addDto);
    }

    /**
     * 修改单位信息
     *
     * @param updateDto 修改入参
     * @return Result
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改单位信息",notes = "修改单位信息")
    public Result update (@RequestBody @Validated DepartmentUpdateDto updateDto) {
        return departmentService.update(updateDto);
    }

    /**
     * 删除单位信息
     *
     * @param id 主键
     * @return Result
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除单位信息",notes = "删除单位信息")
    public Result delete (@RequestParam @NotBlank(message = "主键不能为空!") String id) {
        return departmentService.delete(id);
    }

    /**
     * 批量删除单位信息
     *
     * @param ids 主键集
     * @return Result
     */
    @GetMapping("/delete/batch")
    @ApiOperation(value = "批量删除单位信息",notes = "批量删除单位信息")
    public Result deleteBatch (@RequestParam @NotBlank(message = "主键集不能为空!") List<String> ids) {
        return departmentService.deleteBatch(ids);
    }

    /**
     * 分页查询单位信息
     *
     * @param queryDto 查询入参
     * @return Result<PageModel<DepartmentVo>>
     */
    @PostMapping("/find/all")
    @ApiOperation(value = "分页查询单位信息",notes = "分页查询单位信息")
    public Result<PageModel<DepartmentVo>> findAll (@RequestBody DepartmentQueryDto queryDto) {
        return departmentService.findAll(queryDto);
    }





}
