package zrc.createthread1;

public class Test {
    public static void main(String[] args) {
        System.out.println("Java虚拟机启动main线程");
        MyThread myThread = new MyThread();
        /*
        调用线程的start()方法来启动线程，启动线程的本质就是请求JVM运行相应的线程，这个线程具体在什么时候执行由线程调度器
    (Scheduler)决定。
        注意：
            start()方法调用结束并不意味着子线程开始运行
            run()方法体中的代码就是子线程要执行的任务
            如果开启了多个线程，start()调用的顺序并不一定就是线程启动的顺序
         */
        myThread.start();
        System.out.println("main线程执行完毕");

    }
}
