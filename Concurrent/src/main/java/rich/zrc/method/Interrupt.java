package rich.zrc.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.Interrupt")
public class Interrupt {

    @Test
    public void test1() {
        Thread thread = new Thread(() -> {
            log.debug("sleep...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("interrupt");
        thread.interrupt();
        log.debug("打断标记{}", thread.isInterrupted());
    }


    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.debug("退出了");
                    break;
                }
            }
        }, "t1");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("interrupt");
        thread.interrupt();
    }
}
