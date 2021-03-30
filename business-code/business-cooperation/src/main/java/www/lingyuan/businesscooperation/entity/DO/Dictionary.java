package www.lingyuan.businesscooperation.entity.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: levy
 * @Date: 2021/3/30 12:57
 */
@TableName("dictionary")
@Data
public class Dictionary {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("keyword不能重复,代号")
    private String keyword;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父节点")
    private String parent;

    @ApiModelProperty("数据类型")
    private String directionType;

    @ApiModelProperty("层级关系")
    private Integer levels;


}
