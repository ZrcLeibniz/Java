package rich.zrc.monitor;

/*
应用之互斥
1.为了避免临界区的竞态条件发生，有多种手段可以达到目的
    ·阻塞式的解决方案：synchronized、Lock
    ·非阻塞式的解决方案：原子变量
2.使用阻塞式的解决方案：synchronized来解决上述问题，即【对象锁】，它采用互斥的方式让同一时刻至多只有一个线程能持有【对象锁】，其它
线程再想获取这个【对象锁】时就会阻塞住，这样就能保证拥有锁的线程可以安全的执行临界区的代码，不用担心线程上下文切换
3.注意，虽然java中互斥和同步都可以采用synchronized关键字来完成，但是其区别如下
    ·互斥是保证临界区的竞态条件发生，同一时刻只能有一个线程执行临界区代码
    ·同步是由于线程执行的先后、顺序不同，需要一个线程等待其他线程运行到某个点
 */
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    static int  counter = 0;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    counter--;
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.debug("{}", counter);
    }
}
