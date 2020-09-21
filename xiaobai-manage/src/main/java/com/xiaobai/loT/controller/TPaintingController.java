package com.xiaobai.loT.controller;

import java.util.Map;


import com.xiaobai.loT.vo.TPaintingTopicVo;
import com.xiaobai.loT.vo.TpaintingTopicUuidVo;
import entity.PageUtils;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.loT.entity.TPaintingEntity;
import com.xiaobai.loT.service.TPaintingService;



/**
 * 画作表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:00
 */
@RestController
@RequestMapping("loT/tpainting")
public class TPaintingController {
    @Autowired
    private TPaintingService tPaintingService;


    /**
     * 根据多个主题id查询
     *
     * @param topicIds
     * @return
     */
//    @RequestMapping("/findObjectbyTopicId")
//    public R findObjectbyTopicId(@RequestBody String[] topicIds) {
//
//        return tPaintingService.findObjectbyTopicId(topicIds);
//    }

    /**
     * 删除
     */
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:tpainting:delete")
    public R delete(TpaintingTopicUuidVo[] vos) {

        return tPaintingService.removeMenuByIds(vos);
    }

    /**
     * 搜索条件查询id
     */
    @RequestMapping("/list/{categoryUuid}")
    //  @RequiresPermissions("loT:tpainting:list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable String categoryUuid) {
        //PageUtils page = tPaintingService.queryPage(params);
        PageUtils page = tPaintingService.queryPage(params, categoryUuid);


        return R.ok().put("page", page);
    }


    /**
     * 信息
     */

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("loT:tpainting:save")
    public R save(@RequestBody TPaintingEntity tPainting) {
        tPaintingService.save(tPainting);

        return R.ok();
    }

    /**
     * 修改
     */
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/update")
    //@RequiresPermissions("loT:tpainting:update")
    public R update(TPaintingEntity entity, String[] topicIds) {
        //tPaintingService.updateById(tPainting);
        tPaintingService.updatepaintingById(entity, topicIds);
        return R.ok();
    }


}
