package rich.zrc.monitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test4")
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                lock.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
           for (int i = 0; i < 5000; i++) {
               lock.decrement();
           }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.debug("{}", lock.getCounter());
    }
}

class Lock {
    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
}
