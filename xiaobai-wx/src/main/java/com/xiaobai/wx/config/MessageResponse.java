package com.xiaobai.wx.config;

import lombok.Data;

@Data
public class MessageResponse {

    private String FromUserName;

    private String ToUserName;

    private Long CreateTime;

    private String Content;
}
