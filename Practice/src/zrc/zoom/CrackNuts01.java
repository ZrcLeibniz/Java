package zrc.zoom;

import java.util.Random;

/*
1-1000这1000个数放在含有1001个元素的数组中，只有唯一个元素值重复，其他均只出现一次。
每个数组元素只能访问一次，设计一个算法，将它找出来（不使用辅助空间）
 */
public class CrackNuts01 {
    public static void main(String[] args) {
        int N = 11;
        int[] arr = new int[N];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + 1;
        }
        arr[arr.length - 1] = new Random().nextInt(N);
        int index = new Random().nextInt(12);
        exchange(arr, arr.length - 1, index);
        print(arr);
        System.out.println();
        System.out.println("重复的数字已经被找到为：" + find(arr));
    }

    public static void exchange(int[] arr, int i,  int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int find(int arr[]) {
        int result = 0;
        for (int i = 1; i <= arr.length - 1; i++) {
            result =  result ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
