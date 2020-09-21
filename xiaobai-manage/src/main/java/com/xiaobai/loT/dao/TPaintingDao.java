package com.xiaobai.loT.dao;

import com.xiaobai.loT.entity.TPaintingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 画作表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:00
 */
@Mapper
public interface TPaintingDao extends BaseMapper<TPaintingEntity> {

    List<TPaintingEntity> findObjectById(@Param("paintingIds") List<String> paintingIds);

    int deleteObjects(@Param("ids") List<String> ids);

}
