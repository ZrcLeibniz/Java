package zrc.threadlevel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private Deque<T> deque = new ArrayDeque<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition fullWaitSet = lock.newCondition();
    private Condition emptyWaitSet = lock.newCondition();
    private int capacity;

    public BlockQueue(int capacity) {
        this.capacity = capacity;
    }

    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (deque.isEmpty()) {
                try {
                    if (nanos < 0) {
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (deque.isEmpty()) {
                try {
                    emptyWaitSet.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void put(T task) {
        lock.lock();
        try {
            while (deque.size() == capacity) {
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(task);
            emptyWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }
    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (deque.size() == capacity) {
                try {
                    if (nanos < 0) {
                        return false;
                    }
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(task);
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (deque.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {
                deque.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
