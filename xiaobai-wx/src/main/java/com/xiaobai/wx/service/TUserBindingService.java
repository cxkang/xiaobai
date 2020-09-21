package com.xiaobai.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.wx.entity.TUserBinding;

import java.util.Map;

/**
 * 用户绑定信息
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:38
 */
public interface TUserBindingService extends IService<TUserBinding> {

    PageUtils queryPage(Map<String, Object> params);

    int deleteObject(String dataUuid);
}

