package zrc.offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class JZ29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length) {
            return arrayList;
        }
        sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    private static void exchange(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }

    private static void sort(int[] input, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(input, lo, hi);
        sort(input, lo, partition - 1);
        sort(input, partition + 1, hi);
    }

    private static void sort(int[] input) {
        int lo = 0;
        int hi = input.length - 1;
        sort(input, lo, hi);
    }

    private static int partition(int[] input, int lo, int hi) {
        int key = input[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (less(key, input[--right])) {
                if (right == lo) {
                    break;
                }
            }
            while (less(input[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(input, left, right);
            }
        }
        exchange(input, lo, right);
        return right;
    }

    public static void main(String[] args) {
        int[] i = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(i, 4);
        System.out.println(Arrays.asList(arrayList));
    }
}
