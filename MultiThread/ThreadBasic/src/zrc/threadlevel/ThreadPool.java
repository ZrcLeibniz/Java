package zrc.threadlevel;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private BlockQueue<Runnable> taskQueue;
    private HashSet<Worker> workers = new HashSet<>();
    private int coreSize;
    private long timeOut;
    private TimeUnit timeUnit;
    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeOut, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;

    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else {
//                taskQueue.put(task);
                /*
                    当阻塞队列中已满可以有以下几种选择
                        1.死等
                        2.带超时等待
                        3.放弃任务执行
                        4.让调用者抛出异常
                        5.让调用者自己执行任务
                 */
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.take()) != null) {
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }
                synchronized (workers) {
                    workers.remove(this);
                }
            }
        }
    }
}
