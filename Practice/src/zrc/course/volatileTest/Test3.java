package zrc.course.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

// 如何在不加synchronized的情况下实现原子性
public class Test3 {
    public static void main(String[] args) {
        ResourceIII resourceIII = new ResourceIII();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) { resourceIII.add(); }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) { Thread.yield(); }
        System.out.println(Thread.currentThread().getName() + "\t" + resourceIII.num);
    }
}

class ResourceIII {
    AtomicInteger num = new AtomicInteger();

    public void add() {
        num.getAndIncrement();
    }
}
