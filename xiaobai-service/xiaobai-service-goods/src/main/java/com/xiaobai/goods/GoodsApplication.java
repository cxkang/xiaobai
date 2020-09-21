package com.xiaobai.goods;

import entity.FeignRequestInterceptor;
import entity.TokenDecode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {"com.xiaobai.goods.feign"})
@MapperScan(basePackages = "com.xiaobai.goods.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    public FeignRequestInterceptor feignInterceptor() {
        return new FeignRequestInterceptor();
    }

    @Bean
    public TokenDecode tokenDecode() {
        return new TokenDecode();
    }
}