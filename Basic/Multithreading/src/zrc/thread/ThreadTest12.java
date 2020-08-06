package zrc.thread;

/*
守护线程
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        BakDateThread bakDateThread = new BakDateThread();
        bakDateThread.setName("备份数据的线程");
        // 在线程启动之前，将线程设置为守护线程
        bakDateThread.setDaemon(true);
        bakDateThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BakDateThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}