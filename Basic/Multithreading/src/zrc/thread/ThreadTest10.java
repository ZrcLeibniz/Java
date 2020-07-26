package zrc.thread;

public class ThreadTest10 {
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread thread = new Thread(new MyRunnable04());
        thread.setName("t");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over");
    }
}

class MyRunnable04 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
