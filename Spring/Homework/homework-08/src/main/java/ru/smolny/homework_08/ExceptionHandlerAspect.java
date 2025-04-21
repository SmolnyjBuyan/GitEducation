package ru.smolny.homework_08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {
    @Pointcut("@annotation(ru.smolny.homework_08.RecoverException)")
    public void recoverExceptionMethodPointCut() {}


    @Around("recoverExceptionMethodPointCut()")
    public Object handleExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getReturnType();
        RecoverException recoverException = signature.getMethod().getAnnotation(RecoverException.class);

        try {
            return joinPoint.proceed();
        } catch (Throwable ex) {
            for (Class<? extends RuntimeException> exceptionType : recoverException.noRecoverFor()) {
                if (exceptionType.isInstance(ex)) throw ex;
            }
            return SimpleDefaultValue.get(returnType);
        }
    }

}
