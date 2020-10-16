package zrc.threadmethod.setdaemon;

public class Test {
    public static void main(String[] args) {
        SubThread10 subThread10 = new SubThread10();
        subThread10.setDaemon(true);
        subThread10.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main===" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
