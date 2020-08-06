package zrc.deadlock;

public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        MyThread1 thread1 = new MyThread1(o1, o2);
        Thread thread = new Thread(thread1);
        MyThread2 thread2 = new MyThread2(o1, o2);
        Thread thread3 = new Thread(thread2);
        thread.start();
        thread3.start();
    }
}

class MyThread1 implements Runnable {
    Object o1;
    Object o2;

    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }
        }
    }
}

class MyThread2 implements Runnable {
    Object o1;
    Object o2;

    public MyThread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {

            }
        }
    }
}
