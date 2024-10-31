package com.example.NewProject.Services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class HelperDelete {

    @Pointcut("execution(* com.example.NewProject.Services.*.*(..))")
    public void allServiceMethod() {}

    @Before("allServiceMethod()")
    public void logBefore() {
        log.info("Before the method execution");
    }

    @AfterReturning("allServiceMethod()")
    public void logAfter() {
        log.info("After successful method execution");
    }

    @AfterThrowing(pointcut = "allServiceMethod()", throwing = "ex")
    public void logError(Exception ex) {
        log.error("Exception occurred: " + ex.getMessage(), ex);
    }
}
