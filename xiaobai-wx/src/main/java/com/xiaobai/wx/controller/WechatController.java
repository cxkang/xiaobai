package com.xiaobai.wx.controller;


import com.alibaba.fastjson.JSONObject;
import com.xiaobai.wx.config.MessageResponse;
import com.xiaobai.wx.config.OpenidsRes;
import com.xiaobai.wx.util.WeChatContant;
import com.xiaobai.wx.util.WeChatUtil;
import com.xiaobai.wx.util.WxUtil;
import entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class WechatController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 微信URL接入验证
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping(value = "/weChat")
    @ResponseBody
    public String validate(@RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("echostr") String echostr) {
        //3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (WeChatUtil.checkSignature(signature, timestamp, nonce)) {
            //接入成功
            return echostr;
        }
        //接入失败
        return null;
    }

    @PostMapping("/weChat")
    @ResponseBody
    public String handleMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("test");
        // 返回的文本内容
        request.setCharacterEncoding("UTF-8"); // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8");
        String resqContext = null;
        // xml格式的消息数据
        String respXml = null;
        // 将request交给消息处理类
        Map<String, String> map = WeChatUtil.parseXml(request);
        String mes = null;
        mes = map.get(WeChatContant.Content).toString();
        // Map<String, String> map = XStreamTransformer.fromXml(Map.class, request.getInputStream());
        // 获取消息类型
        String msgType = map.get(WeChatContant.MsgType);
        // 封装返回消息
        MessageResponse responseText = new MessageResponse();
        responseText.setFromUserName(map.get("ToUserName"));
        responseText.setToUserName(map.get("FromUserName"));
        responseText.setCreateTime(System.currentTimeMillis());
        // 根据不同消息类型做出相应的处理
        // 文本消息
        if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_TEXT)) {

            resqContext = "您发送了文本消息";
            respXml = WeChatUtil.sendTextMsg(map, resqContext);
        }
        // 图片消息
        if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_IMAGE)) {
            resqContext = "您发送了图片消息";
        }
        //事件消息
        if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_EVENT)) {
            //获取事件类型
            String eventType = map.get(WeChatContant.Event);
            if (eventType.equals(WeChatContant.EVENT_TYPE_SUBSCRIBE)) {
                //关注
                resqContext = "谢谢你的关注";
            }
            if (eventType.equals(WeChatContant.EVENT_TYPE_UNSUBSCRIBE)) {
                //TODO取消关注
            }
            if (eventType.equals(WeChatContant.EVENT_TYPE_CLICK)) {
                //TODO自定义菜单  判断key  从数据库查询资料并且返回
            }
            if (eventType.equals(WeChatContant.EVENT_TYPE_SCAN)) {
                //TODO扫描二维码
            }
        }
        return respXml;
    }

//    @GetMapping("/subscribes")
//    @ResponseBody
//    //HttpServletRequest request, HttpServletResponse response
//    public  Map<String, String>  logInit() {
//        Map<String, String> map=new HashMap<>();
//        String accessToken = WxUtil.getAccessToken();
//        System.out.println(accessToken);
//        String openIdsUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken;
//        OpenidsRes openids = restTemplate.getForObject(openIdsUrl, OpenidsRes.class);
//        String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + accessToken + "&openid=";
//        for (String openid : openids.getData().getOpenid()) {
//            String currentUrl = userInfoUrl + openid;
//            String data = restTemplate.getForObject(currentUrl, String.class);
//            map.put("data",data);
//            return map;
//        }
//        return null;
//    }


}
