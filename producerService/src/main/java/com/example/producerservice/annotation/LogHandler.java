package com.example.producerservice.annotation;


import com.example.producerservice.model.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogHandler {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.template.url}")
    private String url;

    @Around("within(com.example.producerservice.contoller..*) || @annotation(Log)")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {

        long timeBefore = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long timeAfter = System.nanoTime();

        Log build = Log.builder()
                .returnValue(proceed)
                .args(Arrays.toString(joinPoint.getArgs()))
                .workingMethod(String.valueOf(joinPoint.getSignature().getDeclaringType()))
                .methodName(joinPoint.getSignature().getName())
                .runningTime(timeAfter - timeBefore)
                .build();

        log.info(build.toString());

        restTemplate.postForObject(url + "/api-mongo-log", build, Log.class);

        return proceed;

    }
}
