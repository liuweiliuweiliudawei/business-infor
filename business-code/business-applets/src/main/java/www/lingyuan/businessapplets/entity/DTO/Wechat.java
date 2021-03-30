package www.lingyuan.businessapplets.entity.DTO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: levy
 * @Date: 2021/3/29 13:55
 */
@Data
public class Wechat implements Serializable {

    @ApiModelProperty("临时登录凭证")
    private String code;

    @ApiModelProperty("用户非敏感信息")
    private String rawData;

    @ApiModelProperty("签名")
    private String signature;

    @ApiModelProperty("用户敏感信息")
    private String encrypteData;

    @ApiModelProperty("偏移量")
    private String iv;

    @ApiModelProperty("openid")
    private String openid;

    @ApiModelProperty("session_key")
    private String session_key;



}
