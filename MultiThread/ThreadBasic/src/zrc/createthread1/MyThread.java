package zrc.createthread1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这是子线程打印的内容");
    }
}
