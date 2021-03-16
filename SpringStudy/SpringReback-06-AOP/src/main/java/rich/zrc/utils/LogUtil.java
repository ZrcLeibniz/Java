package rich.zrc.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
切入点表达式的写法：
    固定格式：execution(访问权限符 返回值类型 方法全限定名称(参数列表))
        *: 匹配一个或者多个字符
            可以匹配任意一个参数
            放在路径中可以匹配一层任意路径
            方法访问权限处不能写*
       ..: 匹配任意多个参数和任意多个类型
            匹配任意多层路径
       最模糊的写法：execution(* *.*(..))
       && : 满足两个表达式即可
       || : 满足任意表达式即可
       ! : 不满足这个表达式即可
       通知方法的执行顺序：
            正常执行:
                1.前置通知 @Before
                2.后置通知 @After
                3.返回通知 @AfterReturning
            异常通知:
                1.前置通知 @Before
                2.后置通知 @After
                3.异常通知 @AfterThrowing
 */
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
