package com.xiaobai.user.service;

import com.xiaobai.user.pojo.TUser;

public interface TuserService {


    TUser findByName(String username);

    TUser findById(String id);
}
