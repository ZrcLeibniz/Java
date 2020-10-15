package zrc.threadmethod.currentthread;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("main方法中打印当前线程:" + Thread.currentThread().getName());
        // 创建子线程，调用SunThread1()构造方法，在main方法中调用构造方法，所以构造方法中的当前线程就是main线程
        SubThread1 subThread1 = new SubThread1();
        // 启动子线程，子线程会调用run()方法，所以run()方法中的当前线程就是Thread-0线程
        subThread1.start();
        // 在main方法中直接调用run()方法，没有开启新的线程，所以在run方法中的线程就是main线程
        subThread1.run();
    }
}
