package zrc.exception;

public class ExceptionTest04 {
    public static void main(String[] args) {
        NullPointerException e = new NullPointerException("空指针异常");
        // 获取简单异常信息
        System.out.println(e.getMessage());
        // 打印异常堆栈信息
        e.printStackTrace();
        System.out.println("hello");
    }

}
