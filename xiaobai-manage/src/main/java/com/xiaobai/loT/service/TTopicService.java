package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.loT.entity.TTopicEntity;
import entity.PageUtils;
import entity.R;

import java.util.Map;

/**
 * 画作主题
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
public interface TTopicService extends IService<TTopicEntity> {

    PageUtils queryPage(Map<String, Object> params);


    TTopicEntity getByDataUuid(String dataUuid);

    R removeByDataUuids(String[] dataUuids);
}

