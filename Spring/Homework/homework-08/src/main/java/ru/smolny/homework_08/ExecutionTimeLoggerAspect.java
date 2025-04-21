package ru.smolny.homework_08;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeLoggerAspect {
    @Pointcut("within(ru.smolny.homework_08.TestBean)")
    public void testBeanMethodsPointCut() {}

    @Pointcut("@annotation(ru.smolny.homework_08.LogTimeExecution)")
    public void timerAnnotationMethodPointCut() {}

    @Around("timerAnnotationMethodPointCut()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("{} - {} # {} ms",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                executionTime);
        return result;
    }
}
