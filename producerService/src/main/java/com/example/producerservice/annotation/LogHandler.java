package com.example.producerservice.annotation;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogHandler {
    @Around("within(com.example.producerservice.contoller..*) || @annotation(Log)")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {

        int timeBefore = LocalTime.now().getNano();
        Object proceed = joinPoint.proceed();
        int timeAfter = LocalTime.now().getNano();

        log.info(String.valueOf(proceed));
        log.info(Arrays.toString(joinPoint.getArgs()));
        log.info(joinPoint.getSignature().getDeclaringType() + " " + joinPoint.getSignature().getName());
        log.info(String.valueOf((timeAfter - timeBefore)));

        return proceed;

    }
}
