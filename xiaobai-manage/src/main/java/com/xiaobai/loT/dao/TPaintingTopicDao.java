package com.xiaobai.loT.dao;

import com.xiaobai.loT.entity.TPaintingTopicEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 画作标签
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Mapper
public interface TPaintingTopicDao extends BaseMapper<TPaintingTopicEntity> {

    List<String> findPaintIdsByTopicId(@Param("topids") String[] topicIds);

    void deleteObject(@Param("ids") List<String> list);

    void deleteBatchVos(@Param("entities") List<TPaintingTopicEntity> entities);

    int insertObjects(@Param("paintingUuid") String paintUuid, @Param("topicIds") String[] topicIds);
}
