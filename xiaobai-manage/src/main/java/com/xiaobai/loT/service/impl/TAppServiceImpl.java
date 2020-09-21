package com.xiaobai.loT.service.impl;

import com.xiaobai.loT.util.AppServiceException;
import entity.PageUtils;
import entity.Query;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xiaobai.loT.dao.TAppDao;
import com.xiaobai.loT.entity.TAppEntity;
import com.xiaobai.loT.service.TAppService;


/**
 * @author cxkan
 */
@Service("tAppService")
public class TAppServiceImpl extends ServiceImpl<TAppDao, TAppEntity> implements TAppService {
    @Autowired
    private TAppDao tAppDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TAppEntity> page = this.page(
                new Query<TAppEntity>().getPage(params),
                new QueryWrapper<TAppEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public TAppEntity versionCheck(String appVersion) {

        TAppEntity app = tAppDao.selectOne(new QueryWrapper<TAppEntity>().eq("app_ver", appVersion));
        String appName = app.getAppName();
        TAppEntity entity = tAppDao.checkNewVer(appName);
        if (entity == null) {
            throw new AppServiceException("查询不到本本记录");
        }

        return entity;
    }

    @Override
    public R saveApp(TAppEntity tApp) {
        tApp.setDataUuid(UUID.randomUUID().toString());
        tApp.setCreateTime(new Date());
        tApp.setUpdateTime(new Date());
        int rows = tAppDao.insert(tApp);
        if (rows == 0) {
            return R.error("新增App失败");
        }
        return R.ok();
    }

}