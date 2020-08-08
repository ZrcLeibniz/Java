package zrc.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest14 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread PThread = new Thread(new Producer(list));
        Thread CThread = new Thread(new Consumer(list));
        PThread.setName("生产者线程");
        CThread.setName("消费者线程");
        PThread.start();
        CThread.start();
    }
}

class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (!list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                list.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object remove = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + remove);
                list.notify();
            }
        }
    }
}