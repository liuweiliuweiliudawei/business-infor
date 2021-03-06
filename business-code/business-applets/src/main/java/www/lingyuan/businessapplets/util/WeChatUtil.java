package www.lingyuan.businessapplets.util;



import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: levy
 * @Date: 2021/3/29 15:30
 */
public class WeChatUtil {

    @Value("${wechat.appid}")
    private static String APPID;

    @Value("${wechat.appSecret}")
    private static String SECRET;

    public static JSONObject getSessionKeyOrOpenId(String code){
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,Object> requestUrlParam = new HashMap<String, Object>();
        //小程序appId
        requestUrlParam.put( "appid",APPID );
        requestUrlParam.put( "secret",SECRET );
        //小程序端返回的code
        requestUrlParam.put( "js_code",wxCode );
        //默认参数
        requestUrlParam.put( "grant_type","authorization_code" );
        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSONObject.parseObject(HttpUtil.post(requestUrl,requestUrlParam));
        return jsonObject;
    }
}
