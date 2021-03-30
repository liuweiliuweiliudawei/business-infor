package www.lingyuan.businesscooperation.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: levy
 * @Date: 2021/3/26 10:03
 */
@Data
@TableName("cooperation_info")
public class CooperationInfo implements Serializable {

    private Long id;

    @ApiModelProperty("标题")
    private String cooperationTitle;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("所处行业")
    private String industry;

    @ApiModelProperty("目标用户")
    private String targetUsers;

    @ApiModelProperty("合作区域")
    private String cooperationArea;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("微信号")
    private String wechatNumber;

    @ApiModelProperty("开始时间，格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("结束时间 格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty("我们提供")
    private String weOffer;

    @ApiModelProperty("资源详情")
    private String resourceDetailsOffer;

    @ApiModelProperty("我们需要")
    private String weNeed;

    @ApiModelProperty("资源详情")
    private String resourceDetailsNeed;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("赞")
    private Long fabulous;

    @ApiModelProperty("倒赞")
    private Long praise;

}
