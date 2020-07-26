package zrc.thread;

public class ThreadTest09 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable03());
        thread.setName("t");
        thread.start();
        for (int i = 1; i <= 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

class MyRunnable03 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 10000; i++) {
            if (i % 100 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);

        }
    }
}