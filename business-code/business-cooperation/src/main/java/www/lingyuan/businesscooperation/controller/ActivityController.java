package www.lingyuan.businesscooperation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businesscooperation.entity.DO.Activity;
import www.lingyuan.businesscooperation.service.ActivityService;

import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/26 15:06
 */
@RestController
@Api(description = "活动发布")
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @ApiOperation("分页查询")
    @PostMapping("/getPage")
    public ApiResponse getPage(Page page, Activity activity){
        return ApiResponse.build(activityService.getPage(page,activity));
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/removeById/{id}")
    public ApiResponse removeById(@PathVariable("id")Long id){
        boolean res = activityService.removeById(id);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @ApiOperation("根据id批量删除，list类型")
    @DeleteMapping("/removeByIds")
    public ApiResponse removeByIds(@RequestParam("ids")List<Long> ids){
        boolean res = activityService.removeByIds(ids);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }
    @ApiOperation("新增活动")
    @PutMapping("/save")
    public ApiResponse save(Activity activity){
        boolean res = activityService.save(activity);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @ApiOperation("根据id查询")
    @GetMapping("/getById/{id}")
    public ApiResponse getById(@PathVariable("id")Long id){
        return ApiResponse.build(activityService.getById(id));
    }

}
