package com.xiaobai.goods.controller;


import entity.R;
import entity.TokenDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 获取用户信息
     */
    @Autowired
    private TokenDecode tokenDecode;

    @RequestMapping("/test")
    public R test() {
        Map<String, String> userInfo = tokenDecode.getUserInfo();
        String username = userInfo.get("username");
        return R.ok().put("username", username);
    }

}
