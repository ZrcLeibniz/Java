package zrc.threadmethod.yield;

public class SubThread5 extends Thread {
    @Override
    public void run() {
        // yield()方法的作用是放弃当前的CPU资源
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 1000000; i++) {
            sum += i;
            Thread.yield();// 线程让步, 放弃CPU的执行权
        }
        long end = System.currentTimeMillis();
        System.out.println("subThread用时:" + (end - begin));
    }
}
