package zrc.course.juc.threadpool;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private HashSet<Worker> workers = new HashSet<>();
    private int coreSize;
    private TimeUnit timeUnit;
    private long timeout;
    private RejectPolicy<Runnable> rejectPolicy;

    class Worker extends Thread {
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
                    task = null;                }
            }
            synchronized (workers) {
                workers.remove(this);
            }
        }
    }

    public ThreadPool(int coreSize, TimeUnit timeUnit, long timeout, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeUnit = timeUnit;
        this.timeout = timeout;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else {
                taskQueue.tryPut(task, rejectPolicy);
            }
        }
    }
}
