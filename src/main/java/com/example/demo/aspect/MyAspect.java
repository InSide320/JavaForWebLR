package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    // Pointcut #1: Всі методи в класі MyService
    @Pointcut("execution(* com.example.demo.services.MyService.*(..))")
    private void myServiceMethods() {
    }

    // Pointcut #2: Всі методи, які повертають значення
    @Pointcut("execution(* *.*(..)) && @annotation(org.springframework.web.bind.annotation.ResponseBody)")
    private void methodsWithResponseBody() {
    }

    // Pointcut #3: Всі методи, що приймають параметр типу String
    @Pointcut("args(String) && within(com.example.demo.*)")
    private void methodsAcceptingStringArgument() {
    }

    // Advice #1: Викликається перед методами в класі MyService
    @Before("myServiceMethods()")
    public void beforeMyServiceMethods(JoinPoint joinPoint) {
        System.out.println("Before executing MyService method: " + joinPoint.getSignature().getName());
    }

    // Advice #2: Викликається після виклику методів з анотацією @ResponseBody
    @After("methodsWithResponseBody()")
    public void afterMethodsWithResponseBody(JoinPoint joinPoint) {
        System.out.println("After executing method with @ResponseBody: " + joinPoint.getSignature().getName());
    }

    // Advice #3: Викликається після виклику методів, які приймають параметр типу String
    @AfterReturning(pointcut = "methodsAcceptingStringArgument()", returning = "result")
    public void afterReturningMethodsWithStringArgument(JoinPoint joinPoint, Object result) {
        System.out.println("After returning from method accepting String argument: " + joinPoint.getSignature().getName());
        System.out.println("Result: " + result);
    }

    // Advice #4: Викликається при виникненні виключення в методах, які приймають параметр типу String
    @AfterThrowing(pointcut = "methodsAcceptingStringArgument()", throwing = "ex")
    public void afterThrowingMethodsWithStringArgument(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception thrown from method accepting String argument: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + ex.getMessage());
    }
}
