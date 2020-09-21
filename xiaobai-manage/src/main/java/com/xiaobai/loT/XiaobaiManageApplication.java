package com.xiaobai.loT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XiaobaiManageApplication {
    public static void main(String[] args) {

        SpringApplication.run(XiaobaiManageApplication.class, args);
    }


}
