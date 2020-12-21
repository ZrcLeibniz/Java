package rich.zrc.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Work")
public class Work {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("烧开水");
            try {
                Thread.sleep(150000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "老王");

        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("洗茶杯");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("拿茶叶");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("泡茶喝");
        }, "小王");
        t1.start();
        t2.start();
    }
}
