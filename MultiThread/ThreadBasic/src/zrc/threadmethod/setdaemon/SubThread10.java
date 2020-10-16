package zrc.threadmethod.setdaemon;

public class SubThread10 extends Thread {
    @Override
    public void run() {
        // Java中的线程分为用户线程与守护线程
        // 守护线程是为其他线程提供服务的线程，如垃圾回收器(GC)就是一个典型的守护线程
        // 守护线程不能单独运行，当JVM中没有其他用户线程，只有守护线程时JVM会退出
        while (true) {
            System.out.println("sub thread......");
        }
    }
}
