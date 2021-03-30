package www.lingyuan.businessapplets.feign.fallback;

import common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import www.lingyuan.businessapplets.entity.DTO.WxUser;
import www.lingyuan.businessapplets.feign.UserClient;

/**
 * @Author: levy
 * @Date: 2021/3/26 16:26
 */
@Component
public class UserClientFallBack implements UserClient {
    @Override
    public ApiResponse getInfoByOpenid(String openid) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse save(WxUser wxUser) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse updateInfoByOpenid(WxUser wxUser) {
        return ApiResponse.error();
    }
}
