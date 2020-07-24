package zrc.thread;

public class ThreadTest07 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread = new Thread(myRunnable2);
        thread.setName("thread");
        thread.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myRunnable2.run = false;
    }
}

class MyRunnable2 implements Runnable {
    boolean run = true;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (run == true) {
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}