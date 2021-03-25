package rich.zrc.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class LogUtilIII {
    public static void logStart(JoinPoint joinPoint) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "开始执行, 方法参数是" + Arrays.asList(joinPoint.getArgs()));
    }

    public static void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "执行完成，结果是" + result);
    }

    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "出现异常，异常是" + exception);
    }

    public static void logEnd(JoinPoint joinPoint) {
        System.out.println("{II}" + joinPoint.getSignature().getName() + "执行结束，参数是" + Arrays.asList(joinPoint.getArgs()));
    }

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
