package com.xiaobai.loT.controller;

import java.util.Arrays;
import java.util.Map;


import entity.PageUtils;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.loT.entity.TPaintingTopicEntity;
import com.xiaobai.loT.service.TPaintingTopicService;


/**
 * 画作标签
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@RestController
@RequestMapping("loT/tpaintingtopic")
public class TPaintingTopicController {
    @Autowired
    private TPaintingTopicService tPaintingTopicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //  @RequiresPermissions("loT:tpaintingtopic:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = tPaintingTopicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("loT:tpaintingtopic:info")
    public R info(@PathVariable("id") Integer id) {
        TPaintingTopicEntity tPaintingTopic = tPaintingTopicService.getById(id);

        return R.ok().put("tPaintingTopic", tPaintingTopic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("loT:tpaintingtopic:save")
    public R save(@RequestBody TPaintingTopicEntity tPaintingTopic) {
        tPaintingTopicService.save(tPaintingTopic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("loT:tpaintingtopic:update")
    public R update(@RequestBody TPaintingTopicEntity tPaintingTopic) {
        tPaintingTopicService.updateById(tPaintingTopic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:tpaintingtopic:delete")
    public R delete(@RequestBody Integer[] ids) {
        tPaintingTopicService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
