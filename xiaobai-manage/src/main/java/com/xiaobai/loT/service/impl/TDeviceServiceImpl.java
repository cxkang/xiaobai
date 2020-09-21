package com.xiaobai.loT.service.impl;

import com.xiaobai.loT.dao.TDeviceDao;
import com.xiaobai.loT.entity.TDeviceEntity;
import com.xiaobai.loT.service.TDeviceService;
import entity.PageUtils;
import entity.Query;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;


@Service("tDeviceService")
public class TDeviceServiceImpl extends ServiceImpl<TDeviceDao, TDeviceEntity> implements TDeviceService {
    @Autowired
    private TDeviceDao tDeviceDao;

    @Autowired
    private Environment environment;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TDeviceEntity> page = this.page(
                new Query<TDeviceEntity>().getPage(params),
                new QueryWrapper<TDeviceEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 设备信息注册
     *
     * @param tDevice
     * @return
     */
    @Override
    public R redister(TDeviceEntity tDevice) {
        List<TDeviceEntity> entityList = tDeviceDao.selectList(new QueryWrapper<TDeviceEntity>().eq("device_id", tDevice.getDeviceId()));


        Profiles profiles = Profiles.of("test");
        int i=0;
        if(entityList==null &&environment.acceptsProfiles(profiles)){
            tDevice.setDataUuid(UUID.randomUUID().toString());
            tDevice.setCreateTime(new Date());
            tDevice.setUpdateTime(new Date());
            tDevice.setRegisterState(0);
            i = tDeviceDao.insert(tDevice);}
        if (i == 0) {
            return R.error("设备信息新增失败");
        }
        return R.ok("信息新增成功");
    }


    @Override
    public R checkRegister(String deviceId) {
        int rows = 0;
        if(StringUtils.isEmpty(deviceId)){
            throw new IllegalArgumentException("无当前设备");
        }
        TDeviceEntity entity = gettDeviceEntity(deviceId);
        if(entity.getRegisterState()==0){
            rows=tDeviceDao.updateStatus(deviceId);
        }
        if (rows == 0) {
            return R.error("更改状态失败");
        }
        return R.ok("更改状态成功");

    }

    @Override
    public R checkStatus(String deviceId) {
        int rows = 0;
        if(StringUtils.isEmpty(deviceId)){
            throw new IllegalArgumentException("无当前设备");
        }
        TDeviceEntity tDeviceEntity = gettDeviceEntity(deviceId);
        if(tDeviceEntity.getRegisterState()==0){
            rows = tDeviceDao.updateStatus(deviceId);
        }
        if (rows!=0){
            return R.ok().put("state",1);
        }
        return R.ok().put("state",tDeviceEntity.getRegisterState());

    }


    private TDeviceEntity gettDeviceEntity(String deviceId) {
        return tDeviceDao.selectOne(new QueryWrapper<TDeviceEntity>().eq("device_id", deviceId));
    }


}