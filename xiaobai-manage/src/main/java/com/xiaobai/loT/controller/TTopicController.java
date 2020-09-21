package com.xiaobai.loT.controller;


import java.util.Date;
import java.util.Map;
import java.util.UUID;


import entity.PageUtils;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.loT.entity.TTopicEntity;
import com.xiaobai.loT.service.TTopicService;


/**
 * 画作主题
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@RestController
@RequestMapping("loT/ttopic")
public class TTopicController {
    @Autowired
    private TTopicService tTopicService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //  @RequiresPermissions("loT:ttopic:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = tTopicService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/manage/info/{dataUuid}")
    //@RequiresPermissions("loT:ttopic:info")
    public R info(@PathVariable("dataUuid") String dataUuid) {
        //TTopicEntity tTopic = tTopicService.getById(id);
        TTopicEntity tTopic = tTopicService.getByDataUuid(dataUuid);
        return R.ok().put("tTopic", tTopic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("loT:ttopic:save")
    public R save(@RequestBody TTopicEntity tTopic) {
        String uuid = UUID.randomUUID().toString();
        tTopic.setDataUuid(uuid);
        tTopic.setUpdateTime(new Date());
        tTopic.setCreateTime(new Date());
        tTopicService.save(tTopic);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("loT:ttopic:update")
    public R update(@RequestBody TTopicEntity tTopic) {
        tTopicService.updateById(tTopic);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:ttopic:delete")
    public R delete(@RequestBody String[] dataUuids) {
        //tTopicService.removeByIds(Arrays.asList(ids));
        return tTopicService.removeByDataUuids(dataUuids);

    }

}
