package www.lingyuan.businessuser.sercice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businessuser.entity.DO.WxUser;

/**
 * @Author: levy
 * @Date: 2021/3/24 15:36
 */
public interface WxUserService extends IService<WxUser> {

    IPage<WxUser> getPage(IPage<Page> page, WxUser wxUser);

    WxUser getInfoByOpenid(String openid);

    int updateInfoByOpenid(WxUser wxUser);

}
