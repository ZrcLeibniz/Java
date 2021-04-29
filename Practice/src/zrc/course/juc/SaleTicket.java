package zrc.course.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
题目:
    三个售票员 卖出 30张票
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) {
                ticket.sale();
            }
        }, "C").start();
       /* java中线程的状态
            1.NEW               新建
            2.RUNNABLE          就绪
            3.BLOCKED           阻塞
            4.WAITING           不见不散
            5.TIMED_WAITING     过时不候
            6.TERMINATED        死亡
        */
    }
}

class Ticket {
    private int number = 30;
    private Lock lock = new ReentrantLock();

    void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第: " + (number--) + "\t张票，还剩下" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}