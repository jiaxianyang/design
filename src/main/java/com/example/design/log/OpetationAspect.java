package com.example.design.log;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
@Configuration
public class OpetationAspect {

    /**
     *
     * @param operationLog
     */
    @Pointcut("@annotation(operationLog)")
    public void pointcut(OperationLog operationLog) {
    }

    @SneakyThrows
    @Around(value = "pointcut(operationLog)")
    public Object around(ProceedingJoinPoint pjp, OperationLog operationLog) {
        Object proceed = pjp.proceed();
        return proceed;
    }

}
