package zrc.threadmethod.yield;

public class Test {
    public static void main(String[] args) {
        // 开启子线程，计算累加和
        SubThread5 subThread5 = new SubThread5();
        subThread5.start();
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 100000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main方法,用时:" + (end - begin));
    }
}
