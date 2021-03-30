package www.lingyuan.businessgateway.controller;

import common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: levy
 * @Date: 2021/3/18 10:01
 */
@RestController
public class Fallbackcontroller {

    @GetMapping("/fallback")
    public ApiResponse fallback(){
        return ApiResponse.error("访问接口出现错误");
    }

}
