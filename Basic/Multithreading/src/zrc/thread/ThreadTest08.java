package zrc.thread;

public class ThreadTest08 {
    public static void main(String[] args) {
//        System.out.println("线程最高优先级---->" + Thread.MAX_PRIORITY);
//        System.out.println("线程默认优先级---->" + Thread.NORM_PRIORITY);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("线程最低优先级---->" + Thread.MIN_PRIORITY);
        Thread thread = new Thread(new MyThread03());
        Thread.currentThread().setPriority(4);
        thread.setName("t");
        thread.setPriority(8);
        thread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }
}

class MyThread03 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
        }
    }
}