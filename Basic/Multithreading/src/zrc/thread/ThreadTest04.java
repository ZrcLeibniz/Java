package zrc.thread;

public class ThreadTest04 {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        // 设置线程的名字
        thread2.setName("ttt");
        thread2.start();
        // 获取线程的名字
        System.out.println(thread2.getName());
        // 获取当前正在执行的线程
        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        for (int i = 0; i < 100; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}