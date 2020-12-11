package rich.zrc.thread;

// 使用Future和Callable接口

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Thread04")
public class Thread04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("Running");
                Thread.sleep(3000);
                return 100;
            }
        });
        Thread thread = new Thread(futureTask, "t4");
        thread.start();
        log.debug("{}", futureTask.get());
    }
}
