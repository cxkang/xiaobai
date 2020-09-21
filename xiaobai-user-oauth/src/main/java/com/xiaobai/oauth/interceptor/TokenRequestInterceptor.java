package com.xiaobai.oauth.interceptor;

import com.xiaobai.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * Feign执行之前，进行拦截
 */
@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {
    /**
     *
     */
    @Override
    public void apply(RequestTemplate template) {

        String tokent = AdminToken.adminToken();
        template.header("Authorization", "bearer" + tokent);
    }
}
