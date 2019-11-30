package com.ywq.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by yangwenqiang on 2019-11-30
 * 继承抽象类 HandlerInterceptorAdapter 实现拦截器
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 接口执行前先执行该方法，false表示拦截，true表示放行
        String name = request.getParameter("name");
        System.out.println("[AuthInterceptor] - 参数中的名字：" + name);
        return true;
    }

}
