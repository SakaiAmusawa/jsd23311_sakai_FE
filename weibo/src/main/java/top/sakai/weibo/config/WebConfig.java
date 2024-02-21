package top.sakai.weibo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //输入addCors自动补全
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //编写自己的请求策略
        registry.addMapping("/**")        //在后端允许匹配客户端发过来的任意请求
                .allowedHeaders("*")//表示任意头部都可以
                .allowedMethods("*")//表示任意请求方式都可以
                .allowedOriginPatterns("*")//任意域都可以
                .allowCredentials(true)//请求可以携带会话相关信息
                .maxAge(3600);//同一请求在一小时内不再检测，直接放行
    }
}
