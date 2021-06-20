package zrc.course.bite;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 单线程池，它会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
        ExecutorService single = Executors.newSingleThreadExecutor();
        // 可重用固定线程数的线程池，超出的线程会在队列中等待
        ExecutorService fixed = Executors.newFixedThreadPool(4);
        // 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收
        ExecutorService caches = Executors.newCachedThreadPool();
        // 创建一个定长线程池，支持定时即周期性任务执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        // 真实使用的线程池
        ExecutorService pool = new ThreadPoolExecutor(
                4, // 核心线程数
                10, // 最大线程数
                60, // 空闲时间数量
                TimeUnit.SECONDS, // 空闲时间单位
                new LinkedBlockingQueue<>(), // 阻塞队列
                new ThreadFactory() { // 线程的创建工厂类
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                // 拒绝策略
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝当前任务 谁提交的任务谁来执行
                // new ThreadPoolExecutor.AbortPolicy();  // 以抛异常的形式来拒绝任务
                // new ThreadPoolExecutor.DiscardOldestPolicy(); // 抛弃最久的任务，将此任务提交
                // new ThreadPoolExecutor.DiscardPolicy() // 直接抛弃当前任务的方式来拒绝执行
        );
    }
}
