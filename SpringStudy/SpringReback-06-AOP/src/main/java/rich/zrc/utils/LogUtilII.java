package rich.zrc.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
可以在通知方法运行的时候，拿到目标方法的详细信息
    1) 只需要为通知方法的参数列表上写一个参数JoinPoint(封装了当前目标方法的详细信息)
    2) 随便写一个参数告诉Spring使用这个参数来接受返回值即可
    3) 随便写一个参数告诉Spring使用这个参数来接受异常即可

Spring对通知方法的唯一要求就是参数列表不能乱写
    所有的参数都要注册进Spring,在注解中写明即可
 */
@Aspect
@Component
public class LogUtilII {
    @Before("execution(public int rich.zrc.impl.MyMathCalculatorII.*(int, int))")
    public static void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "开始执行，参数是" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(public int rich.zrc.impl.MyMathCalculatorII.*(int, int))", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "执行完成，结果是" + result);
    }

    @AfterThrowing(value = "execution(public int rich.zrc.impl.MyMathCalculatorII.*(int, int))", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "出现异常，异常是" + exception);
    }

    @After("execution(public int rich.zrc.impl.MyMathCalculatorII.*(int, int))")
    public static void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "执行结束，参数是" + Arrays.asList(joinPoint.getArgs()));
    }
}
