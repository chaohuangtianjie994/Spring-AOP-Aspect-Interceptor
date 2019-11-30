package com.ywq.config;

import com.ywq.interceptor.CheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * *
 *  * created by yangwenqiang on 2019-11-30
 *  * 这是一个配置类
 */
 @Configuration
public class CheckConfig extends WebMvcConfigurationSupport {

    // 注入拦截器
    @Autowired
    private CheckInterceptor checkInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(checkInterceptor);
        super.addInterceptors(registry);
    }

}

