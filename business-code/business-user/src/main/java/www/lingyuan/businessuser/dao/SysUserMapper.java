package www.lingyuan.businessuser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businessuser.entity.DO.SysUser;

/**
 * @Author: levy
 * @Date: 2021/3/25 16:43
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> getPage(IPage<Page> page, @Param("SysUser")SysUser sysUser);

}
