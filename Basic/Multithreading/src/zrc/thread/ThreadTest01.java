package zrc.thread;
/*
实现线程的两种方式
    1.编写一个类，直接继承java.lang.Thread，重写run方法
    2.编写一个类，实现java.lang.Runnable接口，实现run方法
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程------>" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程分支------>" + i);
        }
    }
}