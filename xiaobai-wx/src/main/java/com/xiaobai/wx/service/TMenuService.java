package com.xiaobai.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.wx.entity.TWxMenu;

import java.util.Map;

/**
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:37
 */
public interface TMenuService extends IService<TWxMenu> {


    void deleteMenu(Integer id);

    void createMenu(TWxMenu tWxMenu);
}

