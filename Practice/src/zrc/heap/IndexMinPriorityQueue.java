package zrc.heap;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        N = 0;
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public int delMin() {
        int minIndex = pq[1];
        exchange(1, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[minIndex] = null;
        N--;
        sink(1);
        return minIndex;
    }

    public void insert(int i, T t) {
        if (contains(i)) {
            return;
        }
        N++;
        items[i] = t;
        pq[N] = i;
        qp[i] = N;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exchange(k, k / 2);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int min;
            if (k * 2 + 1 <= N) {
                if (less(k * 2 + 1, k * 2)) {
                    min = k * 2 + 1;
                } else {
                    min = k * 2;
                }
            } else {
                min = k * 2;
            }
            if (less(k, min)) {
                break;
            } else {
                exchange(k, min);
            }
            k = min;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void changeItem(int i, T t) {
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

    public int minIndex() {
        return pq[1];
    }

    public void delete(int i) {
        int k = qp[i];
        exchange(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[k] = null;
        N--;
        sink(k);
        swim(k);
    }
}
