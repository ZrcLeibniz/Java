package zrc.number;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = random.nextInt(101);
//        System.out.println(num1);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int index = arr.length - 1;
        while (index >= 0) {
            int num = random.nextInt(101);
            if (contains(arr, num)) {
                arr[index--] = num;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean contains(int [] arr, int key) {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, key) < 0;
    }
}
