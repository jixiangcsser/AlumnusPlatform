package team.bxcc.sap.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LogAspect {
    @Pointcut("execution(public * team.bxcc.sap.controller.test.*.*(..))")
    public void test(){
    }
    @Before("test()")
    public void dobefore(JoinPoint joinPoint){
        System.out.println("加上日志！");
    }
}
