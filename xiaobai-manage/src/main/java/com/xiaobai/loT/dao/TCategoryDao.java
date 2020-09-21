package com.xiaobai.loT.dao;

import com.xiaobai.loT.entity.TCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Mapper
public interface TCategoryDao extends BaseMapper<TCategoryEntity> {

}
