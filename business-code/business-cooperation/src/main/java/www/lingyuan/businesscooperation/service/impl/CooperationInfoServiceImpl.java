package www.lingyuan.businesscooperation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.lingyuan.businesscooperation.dao.CooperationInfoMapper;
import www.lingyuan.businesscooperation.entity.DO.CooperationInfo;
import www.lingyuan.businesscooperation.service.CooperationInfoService;

/**
 * @Author: levy
 * @Date: 2021/3/26 10:47
 */
@Service
public class CooperationInfoServiceImpl extends ServiceImpl<CooperationInfoMapper, CooperationInfo> implements CooperationInfoService {
    @Override
    public IPage<CooperationInfo> getPage(IPage<Page> page, CooperationInfo cooperationInfo) {
        return baseMapper.getPage(page,cooperationInfo);
    }
}
