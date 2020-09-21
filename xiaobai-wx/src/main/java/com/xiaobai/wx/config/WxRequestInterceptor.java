package com.xiaobai.wx.config;

import com.alibaba.fastjson.JSONObject;
import com.xiaobai.wx.entity.TUserBinding;
import com.xiaobai.wx.entity.TWxUser;
import com.xiaobai.wx.util.WeChatContant;
import com.xiaobai.wx.util.WxUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * 拦截器
 */
@Component
public class WxRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String backURL = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        JSONObject wxUserInfoJson = (JSONObject) session.getAttribute("User");
        if (wxUserInfoJson != null) {
            return true;
        }
        String code = request.getParameter("code");
//第一次访问
        if (StringUtils.isBlank(code)) {
            response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="
                    + WeChatContant.appID
                    + "&redirect_uri="
                    + URLEncoder.encode(backURL, "UTF-8")
                    + "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
            return false;
        }
        JSONObject jsonObject = WxUtil.getWebAccessToken(code);
        String openId = jsonObject.getString("openid");
        if (openId == null) {
            return false;
        }
        String accessToken = jsonObject.getString("access_token");
        TWxUser userInfo = WxUtil.getUserInfo(accessToken, openId);
        String uuid = UUID.randomUUID().toString();
        TUserBinding tUserBinding = new TUserBinding();
        tUserBinding.setOpenid(userInfo.getOpenId());
        tUserBinding.setCategory("weixin");
        tUserBinding.setDataUuid(uuid);
        tUserBinding.setUserUuid(userInfo.getDataUuid());
        tUserBinding.setCreateTime(new Date());
        tUserBinding.setUpdateTime(new Date());
        session.setAttribute("User", userInfo);
        return true;
    }
}
