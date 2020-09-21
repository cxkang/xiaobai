package com.xiaobai.wx.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobai.wx.entity.TUserBinding;
import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.service.TUserService;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.wx.service.TUserBindingService;
import com.xiaobai.common.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 用户绑定信息
 */
@RestController
@RequestMapping("wx/tuserbinding")
public class TUserBindingController {
    @Autowired
    private TUserBindingService tUserBindingService;

    @Autowired
    private TUserService tUserService;


    @RequestMapping("/removeBind")
    @Transactional
    public String removeBind(HttpServletResponse response, HttpServletRequest request) {


        int i = 0;
        HttpSession session = request.getSession();
        TWxUser user = (TWxUser) session.getAttribute("User");
        String dataUuid = user.getDataUuid();
        i = tUserBindingService.deleteObject(dataUuid);
        if (i != 0) {
            request.setAttribute("msg", "解除绑定成功");
        } else {
            request.setAttribute("msg", "解除绑定失败");
        }
        return "某个跳转页面";

    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("wx:tuserbinding:info")
    public R info(@PathVariable("id") Integer id) {
        TUserBinding tUserBinding = tUserBindingService.getById(id);
        return R.ok().put("tUserBinding", tUserBinding);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("wx:tuserbinding:save")
    public R save(@RequestBody TUserBinding tUserBinding) {
        tUserBindingService.save(tUserBinding);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("wx:tuserbinding:update")
    public R update(@RequestBody TUserBinding tUserBinding) {
        tUserBindingService.updateById(tUserBinding);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("wx:tuserbinding:delete")
    public R delete(@RequestBody Integer[] ids) {
        tUserBindingService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
