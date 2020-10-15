package zrc.threadmethod.currentthread;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        SubThread2 subThread2 = new SubThread2();
        subThread2.setName("subThread2");
        subThread2.start();
        Thread.sleep(5000);
        Thread thread3 = new Thread(subThread2);
        thread3.start();
    }
}
