package www.lingyuan.businessuser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import www.lingyuan.businessuser.entity.DO.WxUser;

/**
 * @Author: levy
 * @Date: 2021/3/24 15:37
 */
@Mapper
public interface WxUserMapper extends BaseMapper<WxUser> {

    IPage<WxUser> getPage(IPage<Page> page, @Param("WxUser") WxUser wxUser);

    WxUser getInfoByOpenid(@Param("openid")String openid);

    int updateInfoByOpenid(@Param("WxUser") WxUser wxUser);

}
