package com.xiaobai.loT.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaobai.loT.entity.TCategoryEntity;
import entity.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
public interface TCategoryService extends IService<TCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<TCategoryEntity> listWithTree();

    void reremoveMenuByIds(List<Integer> asList);
}

