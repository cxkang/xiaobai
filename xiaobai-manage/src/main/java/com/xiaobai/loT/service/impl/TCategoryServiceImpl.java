package com.xiaobai.loT.service.impl;

import entity.PageUtils;
import entity.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.xiaobai.loT.dao.TCategoryDao;
import com.xiaobai.loT.entity.TCategoryEntity;
import com.xiaobai.loT.service.TCategoryService;


@Service("tCategoryService")
public class TCategoryServiceImpl extends ServiceImpl<TCategoryDao, TCategoryEntity> implements TCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TCategoryEntity> page = this.page(
                new Query<TCategoryEntity>().getPage(params),
                new QueryWrapper<TCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<TCategoryEntity> listWithTree() {
        List<TCategoryEntity> entities = baseMapper.selectList(null);
//查找所有分类
        List<TCategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentUuid().equals("0")
        ).map((menu) -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSeqNo() == null ? 0 : menu1.getSeqNo()) - (menu2.getSeqNo() == null ? 0 : menu2.getSeqNo());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void reremoveMenuByIds(List<Integer> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    private List<TCategoryEntity> getChildrens(TCategoryEntity root, List<TCategoryEntity> all) {

        List<TCategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentUuid().equals(root.getDataUuid());
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //2、菜单的排序
            return (menu1.getSeqNo() == null ? 0 : menu1.getSeqNo()) - (menu2.getSeqNo() == null ? 0 : menu2.getSeqNo());
        }).collect(Collectors.toList());

        return children;
    }

}