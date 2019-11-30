package com.ywq;

import com.ywq.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by yangwenqiang on 2019-11-30
 */

@SpringBootApplication
@ServletComponentScan
public class StartApplication implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    // SpringBoot服务的启动入口
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(authInterceptor).addPathPatterns("/test/scopeTest");
    }
}
