package www.lingyuan.businesscooperation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.lingyuan.businesscooperation.dao.DictionaryMapper;
import www.lingyuan.businesscooperation.entity.DO.Dictionary;
import www.lingyuan.businesscooperation.service.DictionaryService;

/**
 * @Author: levy
 * @Date: 2021/3/30 14:24
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
    @Override
    public IPage<Dictionary> getPage(IPage<Page> page, Dictionary dictionary) {
        return baseMapper.getPage(page,dictionary);
    }
}
