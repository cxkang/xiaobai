package com.xiaobai.wx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.xiaobai.wx.dao.TUserDao;
import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.service.TUserService;
import com.xiaobai.wx.util.WxUtil;
import entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;


@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TWxUser> implements TUserService {

    @Autowired
    private TUserDao tUserDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TWxUser> page = this.page(
                new Query<TWxUser>().getPage(params),
                new QueryWrapper<TWxUser>()
        );

        return new PageUtils(page);
    }

    @Override
    public TWxUser getUserInfo(String code, String state) {

        TWxUser userinfo = null;
        JSONObject json = WxUtil.getWebAccessToken(code);
        String webAccessToken = json.getString("access_token");
        //获取用户openid
        String openid = json.getString("openid");
        //   String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeChatContant.appID+ "&secret=" + WeChatContant.appsecret+ "&code=" + code + "&grant_type=authorization_code";
        // String forObject = restTemplate.getForObject(url, String.class);
        //System.out.println(forObject);
        return WxUtil.getUserInfo(webAccessToken, openid);


    }


}