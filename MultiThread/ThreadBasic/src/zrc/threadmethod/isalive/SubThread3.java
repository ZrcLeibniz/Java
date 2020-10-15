package zrc.threadmethod.isalive;

public class SubThread3 extends Thread{
    @Override
    public void run() {
        System.out.println("run方法isAlive=" + this.isAlive());
    }
}
