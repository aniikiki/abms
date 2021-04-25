package com.aniikiki.abms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 解决addCorsMappings执行顺序在自定义拦截器之后导致跨域预检请求失败的问题
 * @author aniikiki
 * @date 2021-04-18 02:38:14 
 */
@Aspect
@Component
@Slf4j
public class PreFlightAspect {

    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(public * com.aniikiki.abms.interceptor.*.preHandle(..))")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
        if (request != null && CorsUtils.isPreFlightRequest(request)) {
            return true;
        } else {
            return jp.proceed();
        }
    }

}
