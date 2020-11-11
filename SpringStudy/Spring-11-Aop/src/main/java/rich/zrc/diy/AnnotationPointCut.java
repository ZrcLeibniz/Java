package rich.zrc.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 使用注解方式实现AOP
@Aspect
public class AnnotationPointCut {
    @Before("execution(* rich.zrc.serviceImpl.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("===方法执行前===");
    }

    @After("execution(* rich.zrc.serviceImpl.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("===方法执行后===");
    }

    @Around("execution(* rich.zrc.serviceImpl.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕前");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕后");
        return null;
    }
}
