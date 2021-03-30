package www.lingyuan.businesscooperation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businesscooperation.entity.DO.CooperationInfo;
import www.lingyuan.businesscooperation.service.CooperationInfoService;

import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/26 10:47
 */
@RestController
@RequestMapping("/cooperationInfo")
@Api(description = "商业合作")
public class CooperationInfoController {
    @Autowired
    private CooperationInfoService cooperationInfoService;

    @PostMapping("/getPage")
    @ApiOperation("分页查询")
    public ApiResponse getPage(Page page,CooperationInfo cooperationInfo){
        return ApiResponse.build(cooperationInfoService.getPage(page,cooperationInfo));
    }

    @GetMapping("/getById/{id}")
    @ApiOperation("根据id获取合作信息")
    public ApiResponse getById(@PathVariable("id")Long id){
        return ApiResponse.build(cooperationInfoService.getById(id));
    }

    @PutMapping("/save")
    @ApiOperation("发布合作信息")
    public ApiResponse save(CooperationInfo cooperationInfo){
        boolean res = cooperationInfoService.save(cooperationInfo);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeByIds")
    @ApiOperation("根据多个id删除，数据类型为list")
    public ApiResponse removeByIds(@RequestParam("ids") List<Long> ids){
        boolean res = cooperationInfoService.removeByIds(ids);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("根据id删除")
    public ApiResponse removeById(@PathVariable("id") Long id){
        boolean res = cooperationInfoService.removeById(id);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

}
