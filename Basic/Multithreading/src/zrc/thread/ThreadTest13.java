package zrc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest13 {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThreadNew());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");
    }
}

class MyThreadNew implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Call Method Begin");
        Thread.sleep(1000 * 10);
        System.out.println("Call Method Over");
        int a = 100;
        int b = 200;
        return a + b;
    }
}