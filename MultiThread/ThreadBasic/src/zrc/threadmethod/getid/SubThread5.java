package zrc.threadmethod.getid;

public class SubThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("threadName:" + Thread.currentThread().getName() + "id:" + Thread.currentThread().getId());
    }
}
