package www.lingyuan.businessuser.entity.DO;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: levy
 * @Date: 2021/3/24 15:35
 * 对数据库中字段的映射类，必须实现Serializable
 */
@Data
@TableName("wx_user")
public class WxUser implements Serializable {
    @TableId
    private long id;

    @NotNull
    private String openid;

    @NotNull
    private String sessionKey;

    private String nickname;

    private String avatarurl;

    @ApiModelProperty("0-男，1-女")
    private String gender;

    private String country;

    private String province;

    private String city;

    private String language;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间，格式：yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间，格式：yyyy-MM-dd HH:mm:ss")
    private Date uptime;


    private String mobile;

}
