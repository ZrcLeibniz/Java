package zrc.thread;

public class ThreadTest05 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

