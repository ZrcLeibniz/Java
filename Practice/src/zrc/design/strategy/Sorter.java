package zrc.design.strategy;

public class Sorter<T> {
    public void sort(T[] a, Comparator<T> comparator) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(comparator, a[j], a[j + 1])) {
                    exchange(a, j, j + 1);
                }
            }
        }
    }

    private void exchange(T[] a, int v, int w) {
        T temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }

    private boolean greater(Comparator<T> comparator, T t1, T t2) {
       return comparator.compareTo(t1, t2);
    }
}
