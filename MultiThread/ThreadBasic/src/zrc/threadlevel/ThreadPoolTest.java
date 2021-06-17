package zrc.threadlevel;

/*
    ThreadPoolExecutor使用int的高三位标识线程池状态，低29位表示线程数量：
        1.RUNNING 111 接收新任务 处理阻塞队列任务
        2.SHUTDOWN 000 不接受新任务 处理阻塞队列任务
        3.STOP 001 不接受新任务 不处理阻塞队列任务
        4.TIDYING 010 任务全执行完毕，活动线程为0即将进入终结
        5.TERMINATED 011 终结状态

    ThreadPoolExecutor的构造方法
        ·corePoolSize 核心线程数目
        ·maximumPoolSize 最大线程数目
        ·keepAliveTime 生存时间 - 针对救急线程
        ·unit 时间单位 - 针对救急线程
        ·workQueue 阻塞队列
        ·threadFactory 线程工厂 - 可以为线程创建时起个好名字
        ·handler 拒绝策略

        当所有的核心线程都在工作，并且阻塞队列已经无法容纳新的任务，救急线程就会工作
            救急线程数量 = 最大线程数目 - 核心线程数目

        当线程达到maximumPoolSize仍然有新任务到达时这时会执行拒绝策略，JDK提供了4种拒绝策略
            ·AbortPolicy: 让调用者抛出RejectExecutionException异常， 这是默认策略
            ·CallerRunPolicy: 让调用者运行任务
            ·DiscardPolicy: 放弃本次任务
            ·DiscardOldestPolicy: 放弃队列中最早的任务，本任务取而代之

            ·Dubbo的实现是在抛出RejectExecutionException异常之前会记录日志，并dump线程栈信息，方便定位问题
            ·Netty的实现是创建一个新的线程来执行任务
            ·ActiveMQ的实现是带超时等待(60s)尝试放入队列
            ·PinPoint的实现，它使用了一个拒绝策略链，会之一尝试策略链红的每种拒绝策略
 */
public class ThreadPoolTest {
}
