package rich.zrc.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogUtil {
    @Before("execution(public int rich.zrc.impl.MyMathCalculator.*(int, int))")
    public static void logStart() {
        System.out.println("开始执行，参数是");
    }

    @AfterReturning("execution(public int rich.zrc.impl.MyMathCalculator.*(int, int))")
    public static void logReturn() {
        System.out.println("执行完成，结果是");
    }

    @AfterThrowing("execution(public int rich.zrc.impl.MyMathCalculator.*(int, int))")
    public static void logException() {
        System.out.println("出现异常，异常是");
    }

    @After("execution(public int rich.zrc.impl.MyMathCalculator.*(int, int))")
    public static void logEnd() {
        System.out.println("执行结束，参数是");
    }
}
