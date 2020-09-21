package com.xiaobai;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GatewayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayWebApplication.class, args);
    }

    @Bean(name = "ipKeyResolver")
    public KeyResolver keyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //1.获取请求request对象
                ServerHttpRequest request = exchange.getRequest();
                //2.从request中获取ip地址
                String hostString = request.getRemoteAddress().getHostString();//Ip地址

                //3.返回
                return Mono.just(hostString);
            }
        };
    }
}