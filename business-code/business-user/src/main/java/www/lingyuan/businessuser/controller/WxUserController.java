package www.lingyuan.businessuser.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businessuser.entity.DO.WxUser;
import www.lingyuan.businessuser.sercice.WxUserService;

import java.util.Date;
import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/24 15:03
 */
@Api(description = "小程序用户管理")
@RestController
@RequestMapping("/wxUser")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    @GetMapping("/getId/{id}")
    @ApiOperation("根据id查询")
    public ApiResponse getWxUserById(@PathVariable("id") Long id){
        return ApiResponse.build(wxUserService.getById(id));
    }

    @PostMapping("/getPage")
    @ApiOperation("根据条件分页")
    public ApiResponse getPage(Page page, WxUser wxUser){
        return ApiResponse.build(wxUserService.getPage(page,wxUser));
    }

    @PutMapping("/save")
    @ApiOperation("添加")
    public ApiResponse save(WxUser wxUser){
        wxUser.setCtime(new Date());
        boolean res = wxUserService.save(wxUser);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeByIds")
    @ApiOperation("根据id删除，数据类型为list")
    public ApiResponse removeByIds(@RequestParam("ids") List<Long> ids){
        boolean res = wxUserService.removeByIds(ids);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("根据id删除")
    public ApiResponse removeById(@PathVariable("id") Long id){
        boolean res = wxUserService.removeById(id);
        if (res){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }

    @GetMapping("/getInfoByOpenid/{openid}")
    @ApiOperation("根据openid查询")
    public ApiResponse getInfoByOpenid(@PathVariable("openid")String openid){
        return ApiResponse.build(wxUserService.getInfoByOpenid(openid));
    }


    @PostMapping("/updateInfoByOpenid")
    @ApiOperation("根据openid更新")
    public ApiResponse getInfoByOpenid(WxUser wxUser){
        if (wxUserService.updateInfoByOpenid(wxUser)!=0){
            return ApiResponse.success();
        }
        return ApiResponse.error();
    }


}
