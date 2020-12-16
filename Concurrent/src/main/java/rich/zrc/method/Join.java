package rich.zrc.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.Join")
public class Join {
    private static int r = 0;
    private static int r1 = 0;
    private static int r2 = 0;

    @Test
    public void test1() throws InterruptedException {
        log.debug("开始");
        Thread thread = new Thread(() -> {
            log.debug("开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        });
        thread.start();
        thread.join();
        log.debug("结果为：{}", r);
        log.debug("结束");
    }

    @Test
    public void test2() {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 10;
        });

        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        log.debug("join begin");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 join end");
        log.debug("join begin");
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t2 join end");
        long end = System.currentTimeMillis();
        log.debug("r1:{} r2:{} cost:{}", r1, r2, end - start);
    }

    @Test
    public void test3() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                r1 = 10;
                r2 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        thread.start();
        log.debug("join begin");
        try {
            thread.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.debug("r1:{} r2:{} cost:{}", r1, r2, end - start);
    }
}
