package ru.smolny;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class ExecutionTimeLogAspect {
    private final ExecutionTimeLogProperties properties;

    @Pointcut("@annotation(ru.smolny.ExecutionTimeLog)")
    public void timerAnnotationMethodPointCut() {}

    @Around("timerAnnotationMethodPointCut()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!properties.isEnabled()) return joinPoint.proceed();

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
