package rich.zrc.thread;

// 使用Lambda表达式创建线程

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Thread03")
public class Thread03 {

    public static void main(String[] args) {
        Runnable runnable = () -> log.debug("running");
        Thread thread = new Thread(runnable, "t3");
        thread.start();
        log.debug("running");
    }
}
