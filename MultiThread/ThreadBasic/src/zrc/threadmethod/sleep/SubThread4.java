package zrc.threadmethod.sleep;

public class SubThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("run, threadName=" + Thread.currentThread().getName() + ",begin" + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run, threadName=" + Thread.currentThread().getName() + ",end" + System.currentTimeMillis());
    }
}
