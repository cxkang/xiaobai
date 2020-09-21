package com.xiaobai.loT;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaobai.loT.dao.TDeviceDao;
import com.xiaobai.loT.entity.TDeviceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Autowired
    private TDeviceDao tDeviceDao;

    @Test
    public void test() {

        TDeviceEntity entity = tDeviceDao.selectOne(new QueryWrapper<TDeviceEntity>().eq("device_id", "1"));
        System.out.println(entity);
        }


    }
