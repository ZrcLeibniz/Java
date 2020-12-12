package rich.zrc.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Start_VS_Run")
public class Start_VS_Run {
    public static void main(String[] args) {
        Thread thread = new Thread("t1"){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        thread.start();
        thread.run();
    }
}
