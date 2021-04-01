package www.lingyuan.businessapplets.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.ApiResponse;
import common.ResponseStatus;
import common.util.JWTRSA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.lingyuan.businessapplets.entity.DTO.Wechat;
import www.lingyuan.businessapplets.entity.DTO.WxUser;
import www.lingyuan.businessapplets.feign.UserClient;
import www.lingyuan.businessapplets.service.WechatLoginService;
import www.lingyuan.businessapplets.util.AES;
import www.lingyuan.businessapplets.util.RedisUtils;
import www.lingyuan.businessapplets.util.WeChatKey;
import www.lingyuan.businessapplets.util.WeChatUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: levy
 * @Date: 2021/3/29 11:14
 */
@Service
public class WechatLoginServiceImpl implements WechatLoginService {
    private static Logger log = LoggerFactory.getLogger(WechatLoginServiceImpl.class);
    @Autowired
    private RedisUtils redisTemplate;
    @Autowired
    private UserClient userClient;


    @Override
    public ApiResponse doLogin(Wechat wechat) {
        Map<String,Object> map = new HashMap<>();
        String token = null;
        log.info("开始授权登录");
        if (wechat.getCode()==null && wechat.getIv()==null && wechat.getEncrypteData()==null
                && wechat.getRawData()==null && wechat.getSignature()==null){
            return ApiResponse.error(ResponseStatus.NOT_FOUND_EXCEPTION.getMsg());
        }
        //签名
        JSONObject rawDataJson = JSON.parseObject(wechat.getRawData());
        //获取openid和sessionkey
        JSONObject SessionKeyOpenid = WeChatUtil.getSessionKeyOrOpenId(wechat.getCode());

        String openid = SessionKeyOpenid.getString("openid");
        Object info = redisTemplate.get(WeChatKey.WXUSER_OPENID_KEY+openid);

        String sessionKey = SessionKeyOpenid.getString("session_key");
        if (info==null){
            String nickName = rawDataJson.getString( "nickName" );
            String avatarUrl = rawDataJson.getString( "avatarUrl" );
            String gender  = rawDataJson.getString( "gender" );
            String city = rawDataJson.getString( "city" );
            String country = rawDataJson.getString( "country" );
            String province = rawDataJson.getString( "province" );
            //解密获取手机号
            String phoneStr = AES.wxDecrypt(wechat.getEncrypteData(),sessionKey,wechat.getIv());

            WxUser user = new WxUser();
            user.setOpenid( openid );
            user.setCtime( new Date(  ) );
            user.setSessionKey( sessionKey );
            user.setCountry(country);
            user.setAvatarurl( avatarUrl );
            user.setProvince(province);
            user.setCity(city);
            user.setNickname(nickName);
            user.setUptime(new Date());
            user.setGender(gender);
            user.setMobile(phoneStr);
            token = JWTRSA256.buildToken(user);

            userClient.save(user);
        }else {
            log.info("已存在，做修改分析");
        }
        JSONObject sessionObj = new JSONObject();
        sessionObj.put("openid",openid);
        sessionObj.put("sessionKey",sessionKey);
        redisTemplate.set(WeChatKey.WXUSER_OPENID_KEY+openid,sessionObj);
        return ApiResponse.build(token);
    }
}
