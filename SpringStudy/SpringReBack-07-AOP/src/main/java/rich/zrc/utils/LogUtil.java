package rich.zrc.utils;

public class LogUtil {
    public static void logStart() {
        System.out.println("开始执行，参数是");
    }

    public static void logReturn() {
        System.out.println("执行完成，结果是");
    }

    public static void logException() {
        System.out.println("出现异常，异常是");
    }

    public static void logEnd() {
        System.out.println("执行结束，参数是");
    }
}
