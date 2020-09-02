package zrc.offer;

import java.util.Arrays;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class JZ28 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        double lim = array.length % 2 == 0 ? array.length / 2 : array.length / 2 + 1 / 2;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > lim) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 4, 2, 4};
        int i = MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }
}
