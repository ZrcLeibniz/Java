package zrc.thread;
/*

 */
public class ThreadTest02 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程----->" + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程----->" + i);
        }
    }
}