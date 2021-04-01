package www.lingyuan.businessweb.feign.fallback;

import common.ApiResponse;
import org.springframework.stereotype.Component;
import www.lingyuan.businessweb.entity.DTO.SysUser;
import www.lingyuan.businessweb.feign.SysUserClient;

import java.util.List;

/**
 * @Author: levy
 * @Date: 2021/3/31 14:23
 */
@Component
public class SysUserFallBack implements SysUserClient {
    @Override
    public ApiResponse getId(Long id) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse removeById(Long id) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse removeByIds(List<Long> ids) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse sysUser(SysUser sysUser) {
        return ApiResponse.error();
    }

    @Override
    public ApiResponse getByUserName(String username) {
        return ApiResponse.error();
    }
}
