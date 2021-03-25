package rich.zrc.utils;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class LogUtilII {
    public static void logStart(JoinPoint joinPoint) {
        System.out.println("{I}" + joinPoint.getSignature().getName() + "开始执行，参数是" + Arrays.asList(joinPoint.getArgs()));
    }

    public static void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("{I}" + joinPoint.getSignature().getName() + "执行完成，结果是" + result);
    }

    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("{I}" + joinPoint.getSignature().getName() + "出现异常，异常是" + exception);
    }

    public static void logEnd(JoinPoint joinPoint) {
        System.out.println("{I}" + joinPoint.getSignature().getName() + "执行结束，参数是" + Arrays.asList(joinPoint.getArgs()));
    }
}
