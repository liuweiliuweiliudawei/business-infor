package www.lingyuan.businessuser.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businessuser.entity.DO.SysUser;
import www.lingyuan.businessuser.sercice.SysUserService;

import java.util.Date;
import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/25 16:47
 */
@RestController
@Api(description = "Web用户管理")
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/getPage")
    @ApiOperation("/分页查询")
    public ApiResponse getPage(Page page, SysUser sysUser){
        return ApiResponse.build(sysUserService.getPage(page,sysUser));
    }

    @GetMapping("/getId/{id}")
    @ApiOperation("/根据id查询")
    public ApiResponse getId(@PathVariable("id")Long id){
        return ApiResponse.build(sysUserService.getById(id));
    }

    @PutMapping("/save")
    @ApiOperation("/新增用户")
    public ApiResponse save(SysUser sysUser){
        sysUser.setCtime(new Date());
        boolean res = sysUserService.save(sysUser);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeByIds")
    @ApiOperation("/根据id删除,list传参")
    public ApiResponse removeByIds(@RequestParam("ids") List<Long> ids){
        boolean res = sysUserService.removeByIds(ids);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("根据id删除")
    public ApiResponse removeById(@PathVariable("id") Long id){
        boolean res = sysUserService.removeById(id);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }


    @GetMapping("/getByUserName")
    @ApiOperation("/根据username查询")
    public ApiResponse getUerByUserName(@RequestParam("username")String username){
        return ApiResponse.build(sysUserService.getByUserName(username));
    }

}
