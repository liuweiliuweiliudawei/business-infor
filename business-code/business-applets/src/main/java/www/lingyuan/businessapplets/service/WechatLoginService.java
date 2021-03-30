package www.lingyuan.businessapplets.service;

import common.ApiResponse;
import www.lingyuan.businessapplets.entity.DTO.Wechat;

/**
 * @Author: levy
 * @Date: 2021/3/29 11:14
 */
public interface WechatLoginService {

    ApiResponse doLogin(Wechat wechat);

}
