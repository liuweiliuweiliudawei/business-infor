package www.lingyuan.businessapplets.controller;

import common.ApiResponse;
import common.util.JWTRSA256;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businessapplets.entity.DTO.Wechat;
import www.lingyuan.businessapplets.entity.DTO.WxUser;
import www.lingyuan.businessapplets.feign.UserClient;
import www.lingyuan.businessapplets.service.WechatLoginService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: levy
 * @Date: 2021/3/29 17:28
 */
@RestController
@RequestMapping("/wechat")
@Api(description = "登录")
public class LoginController {

    @Autowired
    private WechatLoginService wechatLoginService;
    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ApiResponse wxChatLogin(Wechat wechat){
        return ApiResponse.build(wechatLoginService.doLogin(wechat));
    }

    @GetMapping("/getInfoByOpenid/{openid}")
    @ApiOperation("根据openid获取用户信息")
    public ApiResponse getInfoByOpenid(@PathVariable("openid")String openid){
        return userClient.getInfoByOpenid(openid);
    }

    @GetMapping("/getInfoByOpenida")
    @ApiOperation("测试")
    public ApiResponse getInfoByOpenid2(@RequestParam("openid")String openid){
        WxUser wxUser = new WxUser();
        wxUser.setOpenid("Asdasdasd123");
        wxUser.setMobile("15884298898");
        wxUser.setUptime(new Date());
        wxUser.setAvatarurl("www.baidu.com");
        wxUser.setOpenid(openid);
        String token = JWTRSA256.buildToken(wxUser);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("token",token);
        return ApiResponse.build(map);
    }

}
