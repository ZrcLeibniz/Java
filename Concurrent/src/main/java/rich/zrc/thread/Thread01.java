package rich.zrc.thread;

import lombok.extern.slf4j.Slf4j;

// 使用Thread创建线程

@Slf4j(topic = "c.Thread01")
public class Thread01 {
    public static void main(String[] args) {
        //final Logger logger = Logger.getLogger(Test.class);
        Thread t1 = new Thread("rich") {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t1.start();
        log.debug("running");
    }
}
