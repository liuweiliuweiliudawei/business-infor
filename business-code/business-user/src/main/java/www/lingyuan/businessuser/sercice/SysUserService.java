package www.lingyuan.businessuser.sercice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businessuser.entity.DO.SysUser;

/**
 * @Author: levy
 * @Date: 2021/3/25 16:44
 */
public interface SysUserService extends IService<SysUser> {

    IPage<SysUser> getPage(IPage<Page> page,SysUser sysUser);

    SysUser getByUserName(String username);

}
