package com.xiaobai.wx.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OpenidsRes {

    private Integer total;

    private Integer count;

    private Data data;

    @lombok.Data
    public static class Data {

        private List<String> openid;

        @JsonProperty("next_openid")
        private String nextOpenid;

    }
}
