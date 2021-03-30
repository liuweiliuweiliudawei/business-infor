package www.lingyuan.businessuser.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: levy
 * @Date: 2021/3/25 16:31
 */
@Data
@TableName("sys_user")
public class SysUser {

    private Long id;

    private String username;

    private String password;

    private String salt;

    private Long roleId;

    private Integer locked;

    @ApiModelProperty("创建时间，格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    private String gender;


}
