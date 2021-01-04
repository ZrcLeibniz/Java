package rich.zrc.monitor;

/*
临界区
1.一个程序运行多个线程本身是没有问题的
2.问题出在多个线程访问共享资源
    ·多个线程读共享资源其实也没有问题
    ·在多个线程对共享资源读写操作时发生指令交错，就会出现问题
3.一段代码块内如果存在对象共享资源的多线程读写操作，成这段代码块为临界区

竞态条件
1.多个线程在临界区内执行，由于执行序列不同而导致结果无法预测称之为产生了竞态条件
 */
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("{}", counter);
    }
}
