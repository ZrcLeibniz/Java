package zrc.exception;

public class ExceptionTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c = a / b;
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("堆满了");
        System.out.println(outOfMemoryError);
        StackOverflowError stackOverflowError = new StackOverflowError("栈溢出");
        System.out.println(stackOverflowError);
    }
}
