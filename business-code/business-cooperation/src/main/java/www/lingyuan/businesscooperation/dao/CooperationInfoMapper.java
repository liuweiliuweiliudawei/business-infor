package www.lingyuan.businesscooperation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businesscooperation.entity.DO.CooperationInfo;

/**
 * @Author: levy
 * @Date: 2021/3/26 10:19
 */
@Mapper
public interface CooperationInfoMapper extends BaseMapper<CooperationInfo> {

    IPage<CooperationInfo> getPage(IPage<Page> page, @Param("CooperationInfo")CooperationInfo cooperationInfo);

}
