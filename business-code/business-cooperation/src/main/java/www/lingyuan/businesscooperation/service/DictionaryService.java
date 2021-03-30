package www.lingyuan.businesscooperation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import www.lingyuan.businesscooperation.entity.DO.Dictionary;

/**
 * @Author: levy
 * @Date: 2021/3/30 14:24
 */
public interface DictionaryService extends IService<Dictionary> {

    IPage<Dictionary> getPage(IPage<Page> page, Dictionary dictionary);
}
