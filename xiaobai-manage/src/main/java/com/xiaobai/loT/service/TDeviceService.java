package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.loT.entity.TDeviceEntity;
import entity.PageUtils;
import entity.R;

import java.util.Map;

/**
 * 设备注册表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 08:46:44
 */
public interface TDeviceService extends IService<TDeviceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R redister(TDeviceEntity tDevice);

    R checkRegister(String deviceId);

    R checkStatus(String deviceId);
}

