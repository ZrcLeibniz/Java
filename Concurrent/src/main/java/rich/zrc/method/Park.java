package rich.zrc.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.Park")
public class Park {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Thread thread = new Thread(()->{
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
