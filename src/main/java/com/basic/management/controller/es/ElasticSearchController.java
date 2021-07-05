//package com.basic.management.controller.es;
//
//import cn.hutool.core.collection.CollectionUtil;
//import cn.hutool.core.util.StrUtil;
//import com.basic.management.dto.es.EsAddDto;
//import com.basic.management.dto.es.EsSearchDto;
//import com.basic.management.utils.ElasticSearchUtils;
//import com.basic.management.utils.Result;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import javax.validation.constraints.NotEmpty;
//import java.io.IOException;
//import java.net.BindException;
//import java.util.Map;
//
///**
// * 检索测试
// *
// * @author fujie
// */
//
//@RestController
//@RequestMapping("/es")
//@Api(value = "检索工具类",tags = "实现全文检索")
//public class ElasticSearchController {
//
//
//    private final ElasticSearchUtils searchUtils;
//
//    public ElasticSearchController(ElasticSearchUtils searchUtils) {
//        this.searchUtils = searchUtils;
//    }
//
//    /**
//     * 创建索引
//     *
//     * @param index 索引
//     * @return Result
//     * @throws IOException 异常信息
//     */
//    @GetMapping("/create/index")
//    @ApiOperation(value = "创建索引",notes = "创建索引")
//    public Result createIndex (@RequestParam @NotEmpty(message = "索引不能为空！") String index) throws IOException {
//        boolean isSuccess = searchUtils.createIndex(index);
//        if (!isSuccess) {
//            throw new BindException("索引创建失败!");
//        }
//        return Result.success();
//    }
//
//    /**
//     * 提交数据
//     *
//     * @param addDto 数据入参
//     * @return Result
//     * @throws IOException 异常
//     */
//    @PostMapping("/submit/data")
//    @ApiOperation(value = "提交数据",notes = "提交数据")
//    public Result submitData (@RequestBody @Validated EsAddDto addDto) throws IOException {
//        String s = searchUtils.submitData(addDto.getObj(), addDto.getIndex(), addDto.getId());
//        if (StrUtil.isBlank(s)) {
//            throw new BindException("提交数据失败!");
//        }
//        return Result.success();
//    }
//
//
//    @PostMapping("/search/data/by/id")
//    @ApiOperation(value = "通过id查询数据",notes = "通过id查询数据")
//    public Result searchDataById (@RequestBody @Validated EsSearchDto searchDto) throws IOException {
//        Map<String, Object> map = searchUtils.searchDataById(searchDto.getIndex(), searchDto.getId(), searchDto.getFields());
//        if (CollectionUtil.isEmpty(map)) {
//            throw new BindException("查询数据失败!");
//        }
//        return Result.success(map);
//    }
//
//
//
//}
