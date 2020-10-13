package zrc.createthread3;

public class Test {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    System.out.println("sub2 thread:" + i);
                }
            }
        });
        thread1.start();
        for (int i = 1; i <= 100; i++) {
            System.out.println("main thread:" + i);
        }
    }
}
