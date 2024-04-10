package com.sky.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {

//    @Around("execution(* com.sky.mapper.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long begin = System.currentTimeMillis();
        //调用原始操作
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("执行耗时: {} ms", (end - begin) );
        return result;
    }

}
