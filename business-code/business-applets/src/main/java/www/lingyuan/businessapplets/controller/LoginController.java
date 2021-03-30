package www.lingyuan.businessapplets.controller;

import common.ApiResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import www.lingyuan.businessapplets.entity.DTO.Wechat;
import www.lingyuan.businessapplets.entity.DTO.WxUser;
import www.lingyuan.businessapplets.feign.UserClient;
import www.lingyuan.businessapplets.service.WechatLoginService;

/**
 * @Author: levy
 * @Date: 2021/3/29 17:28
 */
@RestController
@RequestMapping("/wechat")
public class LoginController {

    @Autowired
    private WechatLoginService wechatLoginService;
    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    public ApiResponse wxChatLogin(Wechat wechat){
        return ApiResponse.build(wechatLoginService.doLogin(wechat));
    }

    @GetMapping("/getInfoByOpenid/{openid}")
    public ApiResponse getInfoByOpenid(@PathVariable("openid")String openid){
        return userClient.getInfoByOpenid(openid);
    }

    @GetMapping("/getInfoByOpenida")
    public ApiResponse getInfoByOpenid2(@RequestParam("openid")String openid){
        return userClient.getInfoByOpenid(openid);
    }

}
