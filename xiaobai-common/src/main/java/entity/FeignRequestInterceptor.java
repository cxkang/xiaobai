package entity;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        /**
         * 当前用户请求的所有数据 包含请求头和请求参数
         * 用户当前请求的时候对应线程的数量，如果开启了熔断，默认是线程池隔离。
         * 会开启新的线程，需要将熔断策略换成信号量隔离，此时不会开启新的额线程
         */
        try {
            //使用RequestContextHolder工具获取request相关变量
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                //取出request
                HttpServletRequest request = attributes.getRequest();
                //获取所有头文件信息的key
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        //头文件的key
                        String name = headerNames.nextElement();
                        //头文件的value
                        String values = request.getHeader(name);
                        //将令牌数据添加到头文件中
                        requestTemplate.header(name, values);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

