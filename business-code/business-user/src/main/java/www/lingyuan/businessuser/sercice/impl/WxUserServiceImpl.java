package www.lingyuan.businessuser.sercice.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.lingyuan.businessuser.entity.DO.WxUser;
import www.lingyuan.businessuser.dao.WxUserMapper;
import www.lingyuan.businessuser.sercice.WxUserService;

/**
 * @Author: levy
 * @Date: 2021/3/24 15:37
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser> implements WxUserService {

    @Override
    public IPage<WxUser> getPage(IPage<Page> page, WxUser wxUser) {
        return baseMapper.getPage(page,wxUser);
    }

    @Override
    public WxUser getInfoByOpenid(String openid) {
        return baseMapper.getInfoByOpenid(openid);
    }

    @Override
    public int updateInfoByOpenid(WxUser wxUser) {
        return baseMapper.updateInfoByOpenid(wxUser);
    }
}
