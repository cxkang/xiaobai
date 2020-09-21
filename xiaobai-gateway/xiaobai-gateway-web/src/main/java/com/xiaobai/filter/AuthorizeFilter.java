package com.xiaobai.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {


    //令牌头名字
    private static final String AUTHORIZE_TOKEN = "Authorization";

    /***
     * 全局过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取Request、Response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取请求的URI
        String path = request.getURI().getPath();
        if (path.startsWith("/api/user/login") || path.startsWith("/api/loT/tapp/manage")|| path.startsWith("/api/loT/tcategory/manage")
        ||path.startsWith("/api/loT/tdevice/manage")|| path.startsWith("/api/loT/image")|| path.startsWith("/api/loT/ttopic/manage")) {
            //放行
            Mono<Void> filter = chain.filter(exchange);
            return filter;
        }

        //如果是登录、goods等开放的微服务[这里的goods部分开放],则直接放行
//       if(UrlFilter.hasAutorize(request.getURI().toString())){
//            return chain.filter(exchange);
//        }





   //获取头文件中的令牌信息
            String tokent = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
            boolean hasToken = true;

            //如果头文件中没有，则从请求参数中获取
            if (StringUtils.isEmpty(tokent)) {
                tokent = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
                hasToken = false;
            }

        if (StringUtils.isEmpty(tokent)) {
            HttpCookie httpCookie = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if(httpCookie!=null){
                tokent=httpCookie.getValue();
            }
        }

        if (StringUtils.isEmpty(tokent)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();}

            if (StringUtils.isEmpty(tokent)) {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            } else {
                if (!hasToken) {
                    if (!tokent.startsWith("bearer") && !tokent.startsWith("Brarer")) {
                        tokent = "bearer" + tokent;
                        //将令牌封装到头文件中
                        request.mutate().header(AUTHORIZE_TOKEN, tokent);
                    }

                }

            }

            //放行
            return chain.filter(exchange);

    }


    /***
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
