package com.xiaobai.wx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.xiaobai.wx.dao.TUserDao;
import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.service.TUserService;
import entity.Query;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    private TUserDao tUserDao;

    @Test
    public void test() {
        List<TWxUser> tWxUsers = tUserDao.selectBatchIds(null);


    }


}
