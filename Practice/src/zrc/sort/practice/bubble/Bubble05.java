package zrc.sort.practice.bubble;

public class Bubble05 {
    public static void sort(Comparable[] a){
        for (int i = a.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])){
                    exchange(a, j, j + 1);
                }
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    public static void exchange(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
