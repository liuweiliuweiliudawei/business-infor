package www.lingyuan.businesscooperation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import www.lingyuan.businesscooperation.entity.DO.Activity;

/**
 * @Author: levy
 * @Date: 2021/3/26 15:03
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

    IPage<Activity> getPage(IPage<Page> page, @Param("Activity")Activity activity);

}
