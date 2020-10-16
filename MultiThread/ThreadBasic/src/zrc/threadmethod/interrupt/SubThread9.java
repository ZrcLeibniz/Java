package zrc.threadmethod.interrupt;

public class SubThread9 extends Thread {
    @Override
    public void run() {
        // interrupt()可以中断线程
        // 注意:调用线程interrupt()方法仅仅是在当前线程打一个停止标志，并不是真正的停止线程
        for (int i = 0; i <= 10000; i++) {
            if (this.isInterrupted()) {
                System.out.println("当前线程的中断标志为true, 我要退出了");
                return;
            }
            System.out.println("sub thread --->" + i);
        }
    }
}
