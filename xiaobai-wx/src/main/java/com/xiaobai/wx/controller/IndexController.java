package com.xiaobai.wx.controller;

import com.alibaba.fastjson.JSONObject;

import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.service.TUserService;
import com.xiaobai.wx.util.WxUtil;
import entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Date;

public class IndexController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TUserService tUserService;

    /**
     * 需要首先在微信公众号后台配置安全回调域名
     * 授权回调页面，可重定向奥前端由前端处理或由重新向到后端，由接口处理
     * 授权
     *
     * @param code
     * @param state
     */


    @GetMapping("/code")
    @ResponseBody
    public R code(@RequestParam("code") String code, @RequestParam("state") String state) {
        System.out.println("code =" + code);
        System.out.println("state = " + state);
        TWxUser userInfo = tUserService.getUserInfo(code, state);
        return R.ok().put("user", userInfo);

    }

    @RequestMapping("/getToken")
    public String getToken() {
        String accessToken = WxUtil.getAccessToken();
        return accessToken;
    }

    /**
     * 获取JSSDK的签名
     *
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/getSignature")
    @ResponseBody
    public R getSignature(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String jsapi_ticket = WxUtil.getTicket();
        String timestamp = request.getParameter("timestamp");
        String noncestr = request.getParameter("noncestr");
        String url = request.getParameter("url");
        String signature = WxUtil.getSignature(jsapi_ticket, Long.parseLong(timestamp), noncestr, url);
        if (signature != null) {
            return R.ok().put("signature", signature);
        }
        return R.error();

    }


}
