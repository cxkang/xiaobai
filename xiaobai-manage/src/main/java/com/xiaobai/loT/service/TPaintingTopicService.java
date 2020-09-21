package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.loT.entity.TPaintingTopicEntity;
import entity.PageUtils;

import java.util.Map;

/**
 * 画作标签
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
public interface TPaintingTopicService extends IService<TPaintingTopicEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

