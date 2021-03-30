package www.lingyuan.businesscooperation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businesscooperation.entity.DO.Dictionary;
import www.lingyuan.businesscooperation.service.DictionaryService;

import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/30 14:28
 */
@RestController
@Api(description = "字典")
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;


    @PutMapping("/save")
    @ApiOperation("/新增")
    public ApiResponse save(Dictionary dictionary){
        boolean res = dictionaryService.save(dictionary);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("根据id删除")
    public ApiResponse removeById(@PathVariable("id")Long id){
        boolean res = dictionaryService.removeById(id);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeByIds")
    @ApiOperation("根据id批量删除，list类型")
    public ApiResponse removeByIds(List<Long> ids){
        boolean res = dictionaryService.removeByIds(ids);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @GetMapping("/getByid/{id}")
    @ApiOperation("根据id查询")
    public ApiResponse getById(@PathVariable("id")Long id){
        return ApiResponse.build(dictionaryService.getById(id));
    }

    @PostMapping("/getPage")
    @ApiOperation("分页查询")
    public ApiResponse getPage(Page page,Dictionary dictionary){
        return ApiResponse.build(dictionaryService.getPage(page,dictionary));
    }

}
