package com.xiaobai.loT.dao;

import com.xiaobai.loT.entity.TAppEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Android App
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@Mapper
public interface TAppDao extends BaseMapper<TAppEntity> {


    TAppEntity checkNewVer(String appName);
}
