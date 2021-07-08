package com.basic.management.service.department;


import cn.hutool.core.util.IdUtil;
import com.basic.management.dao.department.DepartmentRepository;
import com.basic.management.dto.department.DepartmentAddDto;
import com.basic.management.dto.department.DepartmentQueryDto;
import com.basic.management.dto.department.DepartmentUpdateDto;
import com.basic.management.entity.department.Department;
import com.basic.management.utils.PageModel;
import com.basic.management.utils.Result;
import com.basic.management.vo.department.DepartmentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * 单位业务处理类
 *
 * @author fujie
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Result insert (DepartmentAddDto addDto) {
        Department department = new Department();
        BeanUtils.copyProperties(addDto,department);
        department.setId(IdUtil.simpleUUID());
        department.setIsDelete(false);
        departmentRepository.save(department);
        return Result.success();
    }

    public Result update (DepartmentUpdateDto updateDto) {
        Department department = new Department();
        BeanUtils.copyProperties(updateDto,department);
        departmentRepository.save(department);
        return Result.success();
    }

    public Result delete (String id) {
        Department department = Department.builder().id(id).isDelete(true).build();
        departmentRepository.save(department);
        return Result.success();
    }

    public Result deleteBatch (List<String> id) {
        id.forEach(this::delete);
        return Result.success();
    }

    public Result<PageModel<DepartmentVo>> findAll (DepartmentQueryDto queryDto) {
        return Result.success();
    }
}
