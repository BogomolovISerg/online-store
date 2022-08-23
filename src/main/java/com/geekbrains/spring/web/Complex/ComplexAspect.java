package com.geekbrains.spring.web.Complex;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ComplexAspect {
    public Logger log = Logger.getLogger("reqTime_logger");

    @Around("execution(* com.geekbrains.spring.web.services.*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long t = end - start;
        String tmp = joinPoint.getSignature().toString();
        log.info(String.format("class:%s,invoke time:%s",tmp,t));
        return object;
    }
}
