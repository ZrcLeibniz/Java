package rich.zrc.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
抽取可重用的切入点表达式：
    1.随便声明一个没有实现的返回void的空方法
    2.给方法上标注@PointCut注解
 */

/*
当多个切面同时包覆时：
    先进来的后出去，后进来的先出去
    默认的先后是按照切面类名的字典序
    可以使用@Order注解改变切面执行的顺序,数值越小
 */

@Aspect
@Component
public class LogUtilIII {
    @Pointcut("execution(public int rich.zrc.impl.MyMathCalculatorII.*(int, int))")
    public void myPoint() {

    }

    @Before(value = "myPoint()")
    public static void logStart(JoinPoint joinPoint) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "开始执行, 方法参数是" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "myPoint()", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "执行完成，结果是" + result);
    }

    @AfterThrowing(value = "myPoint()", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "出现异常，异常是" + exception);
    }

    @After("myPoint()")
    public static void logEnd(JoinPoint joinPoint) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "执行结束，参数是" + Arrays.asList(joinPoint.getArgs()));
    }

    /*
    环绕通知是Spring中最强大的通知,相当于一个四合一通知
    环绕通知是优于普通通知执行的，执行顺序如下

        环绕前置
        {
            普通前置
            环绕执行: 目标方法执行
            环绕返回/环绕异常
            环绕后置
        }
        普通后置
        普通返回/出现异常
        在方法执行出现异常的时候，要让普通通知感受到异常，需要将异常抛出
    */
    @Around(value = "myPoint()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {
            // 利用反射调用目标方法
            System.out.println("环绕前置通知," + proceedingJoinPoint.getSignature().getName() + "方法开始");
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("环绕返回通知," + proceedingJoinPoint.getSignature().getName() + "方法返回, 返回值是" + proceed);
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知" + proceedingJoinPoint.getSignature().getName() + "方法出现异常, 异常信息是" + throwable);
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕后置通知" + proceedingJoinPoint.getSignature().getName() + "方法结束");
        }
        return proceed;
    }

}
