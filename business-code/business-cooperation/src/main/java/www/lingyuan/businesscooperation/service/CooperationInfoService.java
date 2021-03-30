package www.lingyuan.businesscooperation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businesscooperation.entity.DO.CooperationInfo;

/**
 * @Author: levy
 * @Date: 2021/3/26 10:47
 */
public interface CooperationInfoService extends IService<CooperationInfo> {

    IPage<CooperationInfo> getPage(IPage<Page> page,CooperationInfo cooperationInfo);


}
