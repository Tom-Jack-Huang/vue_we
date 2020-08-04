package com.hl.vuewe.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author Administrator
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file-save-path}")
    private String fileSavePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/file/**").addResourceLocations("file:"+fileSavePath);


    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域的域名，可以用*表示允许任何域名使用
        //允许任何方法（post、get等）
        //允许任何请求头
        //带上cookie信息
        //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
        registry.addMapping("/**").
                allowedOrigins("https://www.dustyblog.cn").
                allowedMethods("*").
                allowedHeaders("*").
                allowCredentials(true).
                exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }
}
