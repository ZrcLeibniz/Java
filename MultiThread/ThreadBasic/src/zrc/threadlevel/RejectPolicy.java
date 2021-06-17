package zrc.threadlevel;

@FunctionalInterface
public interface RejectPolicy<T> {
    void reject(BlockQueue<T> queue, T task);
}
