package com.xiaobai.loT.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaobai.loT.entity.TDeviceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 设备注册表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 08:46:44
 */
@Mapper
public interface TDeviceDao extends BaseMapper<TDeviceEntity> {

    int updateStatus(@Param("deviceId") String deviceId);
}
