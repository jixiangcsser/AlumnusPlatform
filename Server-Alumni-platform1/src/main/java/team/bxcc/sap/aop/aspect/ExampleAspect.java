package team.bxcc.sap.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * aop 范例 (面向方法切面)
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class ExampleAspect {

    @Pointcut("execution(public * team.bxcc.sap.controller.test.*.*(..))")
    public void test() {
    System.out.println("执行方法");

    }

    @Before("test()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("切面执行(在方法前)!");
        log.error("nihaoa{} ","as");
    }

    @AfterReturning(returning = "ret", pointcut = "test()")
    public void doAfterReturning(Object ret) {
        System.out.println("切面执行完毕(在方法后)!");
    }
}
