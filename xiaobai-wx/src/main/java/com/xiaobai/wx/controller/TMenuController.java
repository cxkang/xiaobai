package com.xiaobai.wx.controller;


import com.xiaobai.wx.entity.TWxMenu;

import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.wx.service.TMenuService;


/**
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:37
 */
@RestController
@RequestMapping("wx")
public class TMenuController {
    @Autowired
    private TMenuService tMenuService;

    /**
     * 创建菜单
     */
    @RequestMapping("/create/menu")
    public R createMenu(@RequestBody TWxMenu tWxMenu) {
        tMenuService.createMenu(tWxMenu);
        return R.ok("创建成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/menu")
    //@RequiresPermissions("wx:tmenu:delete")
    public R delete(@RequestBody Integer id) {
        tMenuService.deleteMenu(id);
        return R.ok();
    }

}
