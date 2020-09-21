package com.xiaobai.loT.dao;


import com.xiaobai.loT.entity.TTopicEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 画作主题
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Mapper
public interface TTopicDao extends BaseMapper<TTopicEntity> {


    int deleteBatchByIds(@PathVariable("dataUuids") String[] dataUuids);
}
