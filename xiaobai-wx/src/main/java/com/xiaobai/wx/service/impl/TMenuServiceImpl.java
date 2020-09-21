package com.xiaobai.wx.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.wx.dao.TMenuDao;
import com.xiaobai.wx.entity.TWxMenu;
import com.xiaobai.wx.service.TMenuService;
import com.xiaobai.wx.util.WxUtil;
import entity.Query;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service("tMenuService")
public class TMenuServiceImpl extends ServiceImpl<TMenuDao, TWxMenu> implements TMenuService {
    @Autowired
    private TMenuDao tMenuDao;


    @Override
    public void createMenu(TWxMenu tWxMenu) {
        String menuText = tWxMenu.getMenuText();
        if (StringUtils.isEmpty(menuText)) {
            throw new IllegalArgumentException("菜单不能为空");
        }
        WxUtil.deleteMenu();
        WxUtil.createMenu(menuText);
        tWxMenu.setCreateTime(new Date());
        tWxMenu.setUpdateTime(new Date());
        tMenuDao.insert(tWxMenu);
    }

    @Override
    public void deleteMenu(Integer id) {
        WxUtil.deleteMenu();
        int rows = tMenuDao.deleteById(id);
        if (rows == 0) {
            throw new IllegalArgumentException("删除失败");
        }
    }

}