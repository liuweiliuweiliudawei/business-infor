package www.lingyuan.businessuser.sercice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.lingyuan.businessuser.dao.SysUserMapper;
import www.lingyuan.businessuser.entity.DO.SysUser;
import www.lingyuan.businessuser.sercice.SysUserService;

/**
 * @Author: levy
 * @Date: 2021/3/25 16:45
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService  {
    @Override
    public IPage<SysUser> getPage(IPage<Page> page, SysUser sysUser) {
        return baseMapper.getPage(page,sysUser);
    }

    @Override
    public SysUser getByUserName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUser>()
        .eq(SysUser::getUsername,username));
    }
}
