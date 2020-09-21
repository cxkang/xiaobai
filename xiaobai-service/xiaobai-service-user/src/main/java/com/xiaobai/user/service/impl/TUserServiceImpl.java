package com.xiaobai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobai.user.dao.TUserMapper;
import com.xiaobai.user.pojo.TUser;
import com.xiaobai.user.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUserServiceImpl implements TuserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser findByName(String username) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", username);
        TUser tUser = tUserMapper.selectOne(queryWrapper);
        return tUser;
    }

    @Override
    public TUser findById(String id) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", id);
        TUser tUser = tUserMapper.selectOne(queryWrapper);
        return tUser;

    }
}
