package ru.itis.javalab.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.itis.javalab.services.MethodService;

@Component
@Aspect
public class MethodAspect {

    private final MethodService methodService;

    public MethodAspect(MethodService methodService) {
        this.methodService = methodService;
    }

    @Around("within(ru.itis.javalab.repositories..*) || within(ru.itis.javalab.controllers..*)")
    public void add(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toShortString().split("\\.")[1];
        methodService.incrementMethod(signature.substring(0, signature.length() - 2));
    }
}
