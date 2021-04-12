package com.jsh.aop.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspectJ {
    private static final Logger logger   = LoggerFactory.getLogger(TestAspectJ.class);

    @Before("execution(* com.jsh.aop.service.*.*Aop(..))")
    public void onBeforeHandler(JoinPoint joinpoint){
        logger.info("=============== onBeforeThing");
    }
    @After("execution(* com.jsh.aop.service.*.*Aop(..))")
    public void onAfterHandler(JoinPoint joinpoint){
        logger.info("=============== onAfterHandler");
    }

    @AfterReturning(pointcut = "execution(* com.jsh.aop.service.*.*Aop(..))", returning = "str")
    public void onAfterReturningHandler(JoinPoint joinpoint, Object str){
        logger.info("@AfterReturning : " + str);
        logger.info("=============== onAfterReturningHandler");
    }

    @Around("execution(* com.jsh.aop.service.*.*Aop(..))")
    public Object onAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("=============== onAroundHandler before");

        Object result   = joinPoint.proceed();

        logger.info("=============== onAroundHandler after");

        return result;
    }
}
