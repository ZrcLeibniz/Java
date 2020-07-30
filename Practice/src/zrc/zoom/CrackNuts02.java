package zrc.zoom;


/*
一个数组里除了一个数字以外，其它数字都出现了两次。请找出该数字。
 */
public class CrackNuts02 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 1, 3, 0, 0, 2, 3, 5, 6, 8, 1, 7};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
