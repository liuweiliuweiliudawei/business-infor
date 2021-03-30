package www.lingyuan.businesscooperation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import www.lingyuan.businesscooperation.entity.DO.Dictionary;

/**
 * @Author: levy
 * @Date: 2021/3/30 14:23
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    IPage<Dictionary> getPage(IPage<Page> page,@Param("Dictionary")Dictionary dictionary);

}
