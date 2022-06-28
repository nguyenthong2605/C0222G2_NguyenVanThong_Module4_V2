package com.codegym.muon_sach.loger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.codegym.muon_sach.controller.BookController.*Show(..))")
    public void allMethodPointCut() {
    }

    @AfterReturning("allMethodPointCut()")
    public void afterCallMeThod(JoinPoint joinPoint) {
        System.err.println("End method name: "
                + joinPoint.getSignature().getName()
                + "Time: " + LocalDate.now());
    }
}
