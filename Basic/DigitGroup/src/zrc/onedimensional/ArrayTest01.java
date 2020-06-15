package zrc.onedimensional;

public class ArrayTest01 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 3, 5, 8};
//        System.out.println(a[3]);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}
