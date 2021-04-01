package www.lingyuan.businessweb.controller;

import com.alibaba.fastjson.JSONObject;
import common.ApiResponse;
import common.util.JWTRSA256;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.lingyuan.businessweb.entity.DTO.SysUser;
import www.lingyuan.businessweb.feign.SysUserClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: levy
 * @Date: 2021/3/31 14:31
 */
@RestController
@RequestMapping("/webLogin")
@Api(description = "web端登录")
public class LoginController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysUserClient sysUserClient;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ApiResponse login(SysUser sysUser){
        if (sysUser==null){
            return ApiResponse.error();
        }
        ApiResponse<JSONObject> userRes = sysUserClient.getByUserName(sysUser.getUsername());
        if (userRes.getData()==null){
            return ApiResponse.error("用户名不存在");
        }
        if (sysUser.getPassword()==null){
            return ApiResponse.error("请输入密码");
        }
        if (!userRes.getData().get("password").equals(sysUser.getPassword())){
            return ApiResponse.error("密码不正确");
        }
        String token = JWTRSA256.buildToken(userRes.getData());
        return ApiResponse.build(token);
    }

    @GetMapping("/test")
    public Object test(){
        Enumeration<String> e = request.getHeaders("token");
        JSONObject jsonObject  = JSONObject.parseObject(JWTRSA256.volidToken(e.nextElement()));
        return jsonObject.get("username");
    }
}
