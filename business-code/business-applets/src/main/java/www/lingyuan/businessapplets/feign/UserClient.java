package www.lingyuan.businessapplets.feign;

import common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import www.lingyuan.businessapplets.entity.DTO.WxUser;
import www.lingyuan.businessapplets.feign.fallback.UserClientFallBack;

/**
 * @Author: levy
 * @Date: 2021/3/26 16:25
 */
@FeignClient(name = "business-user",fallback = UserClientFallBack.class)
public interface UserClient {

    @GetMapping("/wxUser/getInfoByOpenid/{openid}")
    ApiResponse getInfoByOpenid(@PathVariable("openid")String openid);

    @PutMapping("/wxUser/save")
    ApiResponse save(WxUser wxUser);

    @PostMapping("/wxUser/updateInfoByOpenid")
    ApiResponse updateInfoByOpenid(WxUser wxUser);



}
