package com.xiaobai.wx.controller;

import java.util.Arrays;
import java.util.Map;


import com.xiaobai.wx.entity.TWxUser;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.wx.service.TUserService;
import com.xiaobai.common.utils.PageUtils;


/**
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-11 14:44:38
 */
@RestController
@RequestMapping("wx/tuser")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping("/info/{id}")
    //@RequiresPermissions("wx:tuser:info")
    public R info(@PathVariable("id") Integer id) {
        TWxUser tUser = tUserService.getById(id);

        return R.ok().put("tUser", tUser);
    }


}
