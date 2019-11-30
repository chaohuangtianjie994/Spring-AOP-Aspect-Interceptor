package com.ywq.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * created by yanwenqiang on 2019-11-30
 * 定义一个切面类
 */
@Aspect
@Component
public class WebAcpect {

    /**
     * 定义切入点，切入点com.ywq.controller.TestController下的所有函数
     */
    @Pointcut("execution(* com.ywq.controller.TestController.*(..))")
    public void acpectMethod(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("acpectMethod()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        System.out.println("URL：" + request.getRequestURL().toString());
        System.out.println("方法：" + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("类方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("参数 : " + Arrays.toString(joinPoint.getArgs()));
    }

}
