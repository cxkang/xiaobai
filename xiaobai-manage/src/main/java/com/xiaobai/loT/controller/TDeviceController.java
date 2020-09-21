package com.xiaobai.loT.controller;

import java.util.Arrays;
import java.util.Map;


import com.xiaobai.loT.entity.TDeviceEntity;
import com.xiaobai.loT.service.TDeviceService;
import entity.PageUtils;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 设备注册表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 08:46:44
 */
@RestController
@RequestMapping("loT/tdevice")
public class TDeviceController {
    @Autowired
    private TDeviceService tDeviceService;

    /**
     * 设备新增
     */
    @RequestMapping("/manage/register")
    //@RequiresPermissions("wx:tdevice:save")
    public R register(@RequestBody TDeviceEntity tDevice) {

        return tDeviceService.redister(tDevice);
    }
    /**
     * 设备的注册
     */
@RequestMapping("/manage/checkRegister/{deviceId}")
public R checkRegister(@PathVariable("deviceId") String deviceId){

    return  tDeviceService.checkRegister(deviceId);

}

    /**
     * 设备状态查询
     * @return
     */
    @RequestMapping("/manage/checkStatus/{deviceId}")
    //@RequiresPermissions("wx:tdevice:info")
    public R info(@PathVariable("deviceId") String deviceId) {
        return   tDeviceService.checkStatus(deviceId);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //  @RequiresPermissions("wx:tdevice:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = tDeviceService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("wx:tdevice:update")
    public R update(@RequestBody TDeviceEntity tDevice) {
        tDeviceService.updateById(tDevice);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("wx:tdevice:delete")
    public R delete(@RequestBody Integer[] ids) {
        tDeviceService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
