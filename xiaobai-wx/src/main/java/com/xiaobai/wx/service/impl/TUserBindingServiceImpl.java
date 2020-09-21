package com.xiaobai.wx.service.impl;

import com.xiaobai.wx.dao.TUserBindingDao;
import com.xiaobai.wx.dao.TUserDao;
import com.xiaobai.wx.entity.TUserBinding;
import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.service.TUserBindingService;
import entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;


@Service("tUserBindingService")
public class TUserBindingServiceImpl extends ServiceImpl<TUserBindingDao, TUserBinding> implements TUserBindingService {
    @Autowired
    private TUserBindingDao tUserBindingDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TUserBinding> page = this.page(
                new Query<TUserBinding>().getPage(params),
                new QueryWrapper<TUserBinding>()
        );

        return new PageUtils(page);
    }

    @Override
    public int deleteObject(String dataUuid) {

        int i = tUserBindingDao.delete(new QueryWrapper<TUserBinding>().eq("user_uuid", dataUuid));

        return i;
    }


}