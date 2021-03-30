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
 * @Date: 2021/3/26 10:11
 */
@Data
@TableName("activity")
public class Activity implements Serializable {

    private Long id;

    @ApiModelProperty("海报")
    private String poster;

    @ApiModelProperty("活动标题")
    private String title;

    @ApiModelProperty("主办方")
    private String sponsor;

    @ApiModelProperty(value = "行业类型",example = "0")
    private Integer industryType;

    @ApiModelProperty(value = "活动类型",example = "0")
    private Integer activityType;

    @ApiModelProperty("目标群体")
    private String targetUsers;

    @ApiModelProperty(value = "预计人数",example = "0")
    private Integer estimates;

    @ApiModelProperty("活动地点")
    private String activityLocation;

    @ApiModelProperty("详细地址")
    private String detailedAddress;

    @ApiModelProperty("开始时间，格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("结束时间，格式：yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("微信号")
    private String wechatNumber;

    @ApiModelProperty("活动提供")
    private String eventOffer;

    @ApiModelProperty("资源详情")
    private String resourceDetailsOffer;

    @ApiModelProperty("需要资源")
    private String needResources;

    @ApiModelProperty("资源详情")
    private String resourceDetailsNeed;

    @ApiModelProperty("活动详情")
    private String eventDetails;

    @ApiModelProperty("赞")
    private Long fabulous;

    @ApiModelProperty("倒赞")
    private Long praise;

}
