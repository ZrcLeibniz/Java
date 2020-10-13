package zrc.createthread2;

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("main thread:" + i);
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
