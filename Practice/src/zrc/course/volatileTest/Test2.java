package zrc.course.volatileTest;

// 验证volatile不保证原子性
public class Test2 {
    public static void main(String[] args) {
        ResourceII resourceII = new ResourceII();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) { resourceII.addPlus(); }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) { Thread.yield(); }
        System.out.println(Thread.currentThread().getName() + "\t" + resourceII.number);
    }
}

class ResourceII {
    volatile int number = 0;

    public void addPlus() {
        number++;
    }
}