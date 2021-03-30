package www.lingyuan.businesscooperation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businesscooperation.entity.DO.Activity;

/**
 * @Author: levy
 * @Date: 2021/3/26 15:04
 */
public interface ActivityService extends IService<Activity> {

    IPage<Activity> getPage(IPage<Page> page,Activity activity);

}
