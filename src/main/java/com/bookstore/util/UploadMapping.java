package com.bookstore.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadMapping implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //设置请求路径和文件物理路径的映射
        registry.addResourceHandler("/upfile/**").addResourceLocations("file:D:/study/2021 下/gdhd/src/main/resources/static/productImg");
    }
}
