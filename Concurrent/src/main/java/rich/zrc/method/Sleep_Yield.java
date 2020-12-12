package rich.zrc.method;


/*
sleep
1.调用sleep会让当前线程从Running进入Timed Waiting状态
2.其它线程可以使用interrupt方法打断正在睡眠的线程，这时sleep方法会抛出InterruptedException
3.睡眠结束后的线程未必会立刻得到执行
4.建议用TimeUnit的Sleep代替Thread的sleep来获得更好的可读性

yield
1.调用yield会让当前线程从Running进入Runnable状态，然后调度执行其他同优先级的线程。如果这时没有同优先级的线程，那么不能保证让当前线程暂停的效果
2.具体的额实现依赖于操作系统的任务调度器
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Sleep_Yield")
public class Sleep_Yield {
    @Test
    public void test1() {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        log.debug("running");
        thread.start();
        log.debug("t1 state: {}", thread.getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 state: {}", thread.getState());
    }

    @Test
    public void test2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
            log.debug("interrupt...");
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            log.debug("enter");
            TimeUnit.SECONDS.sleep(3);
            log.debug("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test4() {
        Runnable task1 = () -> {
            int count1 = 0;
            for (; ; ) {
                System.out.println("----->1 " + count1++);
            }
        };

        Runnable task2 = () -> {
            int count2 = 0;
            for (; ; ) {
                Thread.yield();
                System.out.println("        ----->2 " + count2++);
            }
        };
        Thread thread1 = new Thread(task1, "t1");
        Thread thread2 = new Thread(task2, "t2");
        thread1.setPriority(10);
        thread1.setPriority(1);
        thread1.start();
        thread2.start();
    }
}
