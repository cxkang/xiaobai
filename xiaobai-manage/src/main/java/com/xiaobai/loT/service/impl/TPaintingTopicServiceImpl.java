package com.xiaobai.loT.service.impl;

import entity.PageUtils;
import entity.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobai.loT.dao.TPaintingTopicDao;
import com.xiaobai.loT.entity.TPaintingTopicEntity;
import com.xiaobai.loT.service.TPaintingTopicService;


@Service("tPaintingTopicService")
public class TPaintingTopicServiceImpl extends ServiceImpl<TPaintingTopicDao, TPaintingTopicEntity> implements TPaintingTopicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TPaintingTopicEntity> page = this.page(
                new Query<TPaintingTopicEntity>().getPage(params),
                new QueryWrapper<TPaintingTopicEntity>()
        );

        return new PageUtils(page);
    }

}