package www.lingyuan.businesscooperation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.lingyuan.businesscooperation.dao.ActivityMapper;
import www.lingyuan.businesscooperation.entity.DO.Activity;
import www.lingyuan.businesscooperation.service.ActivityService;

/**
 * @Author: levy
 * @Date: 2021/3/26 15:05
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Override
    public IPage<Activity> getPage(IPage<Page> page, Activity activity) {
        return baseMapper.getPage(page,activity);
    }
}
