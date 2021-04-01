package www.lingyuan.businessweb.feign;

import com.alibaba.fastjson.JSONObject;
import common.ApiResponse;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businessweb.entity.DTO.SysUser;
import www.lingyuan.businessweb.feign.fallback.SysUserFallBack;

import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/31 14:22
 */
@FeignClient(name = "business-user",fallback = SysUserFallBack.class)
public interface SysUserClient {

    @GetMapping("/sysUser/getId/{id}")
    ApiResponse getId(@PathVariable("id")Long id);

    @DeleteMapping("/sysUser/removeById/{id}")
    ApiResponse removeById(@PathVariable("id")Long id);

    @DeleteMapping("/sysUser/removeByIds")
    ApiResponse removeByIds(@RequestParam("ids")List<Long> ids);

    @PutMapping("/sysUser/save")
    ApiResponse sysUser(SysUser sysUser);

    @GetMapping("/sysUser/getByUserName")
    ApiResponse<JSONObject> getByUserName(@RequestParam("username")String username);


}
