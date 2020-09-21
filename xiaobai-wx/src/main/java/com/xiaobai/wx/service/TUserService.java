package com.xiaobai.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.wx.entity.TWxUser;
import entity.R;

import java.util.Map;

/**
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:38
 */
public interface TUserService extends IService<TWxUser> {


    PageUtils queryPage(Map<String, Object> params);

    TWxUser getUserInfo(String code, String state);

}

