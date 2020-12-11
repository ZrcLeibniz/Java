package rich.zrc.thread;

// 使用Runnable创建线程

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Thread02")
public class Thread02 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread thread = new Thread(runnable, "t2");
        thread.start();
        log.debug("running");
    }
}
