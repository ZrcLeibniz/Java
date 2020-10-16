package zrc.threadmethod.setpriority;

public class SubThread7 extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 1000000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("SubThread7:" + (end - begin));
    }
}
